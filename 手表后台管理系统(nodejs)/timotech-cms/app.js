/*****************************************************
 * Author  : wadecha
 * Version : 0.1
 * Date    :  2015/9/17
 ****************************************************/

var config = require('./config/web_config');
var path = require('path');
var express = require('express');
var session = require('express-session');
var bodyParser = require('body-parser');
var webRoutes = require('./web_routes');
var loader = require('loader');
var _ = require('lodash');
var compress = require('compression');
var errorHandler = require('errorhandler');
var auth = require('./middleware/auth');
// 静态文件目录
var staticDir = path.join(__dirname, 'assets');

// assets 静态文件的合并压缩
var assets = {};
if (config.mini_assets) {
	try {
		assets = require('./assets.json');
	} catch (e) {
		console.log('You must execute `make build` before start app when mini_assets is true.');
		throw e;
	}
}

var parseUrl = require('url').parse(config.site_host);
config.siteDirBaseUrl = __dirname;
config.hostName = parseUrl.hostname || config.site_host;

var app = express();

// configuration in all env
app.set('views', path.join(__dirname, 'views'));
app.set('view engine', 'html');
app.engine('html', require('ejs-mate'));
app.locals._layoutFile = 'layout.html';

app.use(require('response-time')());

// parse application/x-www-form-urlencoded
app.use(bodyParser.urlencoded({extended: true}));
app.use(bodyParser.json());

app.use(require('cookie-parser')(config.session_secret));
app.use(compress());

app.use(session({
	secret: config.session_secret,
	//进行永久是存储
	//store: new MongoStore({
	//    url: config.mongoConfig.connstr
	//}),
	store: new session.MemoryStore(),
	resave: false,
	saveUninitialized: true
}));

// 用户账号验证
app.use(auth.authUser);

/*// 拦截less文件转换成css文件
 app.use(loader.less(__dirname));
 // 设置静态文件*/
app.use('/assets', express.static(staticDir));
app.use('/upload', express.static(path.join(__dirname, 'upload')));

if (!config.debug) {
	app.set('view cache', true);
}

// set app.locals
_.assign(app.locals, {
	config: config,
	loader: loader,
	assets: assets
});

// set csrfToken
app.use(function (req, res, next) {
	res.locals.referer = req.headers.referer;
	res.locals.csrf = req.csrfToken ? req.csrfToken() : '';
	next();
});


app.use('/', webRoutes);

// error handler
if (config.debug) {
	app.use(errorHandler());
}

// 启动 Web 服务
// 微信后台只允许 80 端口
app.listen(config.port, function (err) {
	if (err) {
		console.log('smart watch manage web start failure:', err);
		throw err;
	}

	process.on('uncaughtException', function (err) {
		console.log(err);
		setTimeout(function () {
			process.exit(1);
		}, 100);

	});
});

