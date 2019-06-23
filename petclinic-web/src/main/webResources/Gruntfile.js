module.exports = function(grunt) {
  require('jit-grunt')(grunt);
  grunt.initConfig({
    less: {
      development: {
        options: {
          compress: false,
          yuicompress: true,
          optimization: 2
        },
        files: {
          "../resources/static/css/petclinic.css": "./custom/less/petclinic.less"
        }
      }
    }
  });
  grunt.registerTask('default', ['less']);
};