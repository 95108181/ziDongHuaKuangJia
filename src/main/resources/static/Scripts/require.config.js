
requirejs.config({
  //By default load any module IDs from js/lib
  baseUrl: '',
  //except, if the module ID starts with "app",
  //load it from the js/app directory. paths
  //config is relative to the baseUrl, and
  //never includes a ".js" extension since
  //the paths config could be for a directory.
  paths: {
    'knockout':'knockout-3.2.0.min',
    "jquery": 'lib/jquery-1.8.2.min.js',
    "jquery.validate": '/pluginjquery.validate.min',
    "jquery.validate.unobtrusive": '/pluginjquery.validate.unobtrusive.min',
    "jquery.unobtrusive-ajax": '/pluginjquery.unobtrusive-ajax.min',
    "bootstrap-tagsinput": '/pluginbootstrap-tagsinput.min',
    "summernote": '/plugin/summernote/summernote.min',
    "summernote-zh-CN": 'summernote-zh-CN'
  },
  shim: {
    'jquery': { exports: 'jquery' },
    'knockout':{},
    'jquery.validate': { },
    'jquery.validate.unobtrusive': { deps: ['jquery', 'jquery.validate'] },
    'jquery.unobtrusive-ajax': { deps: ['jquery', 'jquery.validate', 'jquery.validate.unobtrusive'] },
    'bootstrap-tagsinput': { deps: ['jquery'] },
    'summernote': { deps: ['jquery'] },
    'summernote-zh-CN': { deps: ['jquery', 'summernote'] }  
  }
});

