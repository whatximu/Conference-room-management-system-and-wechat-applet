|-- src
    |-- main
        |-- java
        |   |-- com
        |       |-- ssm
        |           |-- controller
        |           |   |-- ApplicationController.java
        |           |   |-- ApplyCriteriaController.java
        |           |   |-- DepartmentController.java
        |           |   |-- RoleController.java
        |           |   |-- RoomController.java
        |           |   |-- UserController.java
        |           |   |-- UserCriteriaController.java
        |           |-- dao
        |           |   |-- ApplicationDao.java
        |           |   |-- ApplyCriteriaDao.java
        |           |   |-- DepartmentDao.java
        |           |   |-- RoleDao.java
        |           |   |-- RoomDao.java
        |           |   |-- UserCriteriaDao.java
        |           |   |-- UserDao.java
        |           |-- entity
        |           |   |-- admin.java
        |           |   |-- Application.java
        |           |   |-- ApplyCount.java
        |           |   |-- ApplyCriteria.java
        |           |   |-- atime.java
        |           |   |-- Department.java
        |           |   |-- equip_info.java
        |           |   |-- notice.java
        |           |   |-- notice_show.java
        |           |   |-- Role.java
        |           |   |-- Room.java
        |           |   |-- solttime.java
        |           |   |-- User.java
        |           |   |-- UserCriteria.java
        |           |-- service
        |           |   |-- ApplicationService.java
        |           |   |-- ApplyCriteriaService.java
        |           |   |-- DepartmentService.java
        |           |   |-- RoleService.java
        |           |   |-- RoomService.java
        |           |   |-- UserCriteriaService.java
        |           |   |-- UserService.java
        |           |   |-- impl
        |           |       |-- ApplicationServiceImpl.java
        |           |       |-- ApplyCriteriaServiceImpl.java
        |           |       |-- DepartmentServiceImpl.java
        |           |       |-- RoleServiceImpl.java
        |           |       |-- RoomServiceImpl.java
        |           |       |-- UserCriteriaServiceImpl.java
        |           |       |-- UserServiceImpl.java
        |           |-- test
        |           |-- util
        |               |-- ExcelUtil.java
        |               |-- Tool.java
        |-- resources
        |   |-- jdbc.properties
        |   |-- mybatis-config.xml
        |   |-- spring-mvc.xml
        |   |-- spring-mybatis.xml
        |-- webapp
            |-- article.jsp
            |-- dept.jsp
            |-- head.jsp
            |-- home.jsp
            |-- index.jsp
            |-- index2.jsp
            |-- role.jsp
            |-- room.jsp
            |-- room_equip.jsp
            |-- user.jsp
            |-- css
            |   |-- bootstrap.min.css
            |   |-- fileinput-rtl.css
            |   |-- fileinput-rtl.min.css
            |   |-- fileinput.css
            |   |-- fileinput.min.css
            |   |-- font-awesome.min.css
            |   |-- index2.css
            |   |-- login.css
            |   |-- style.css
            |-- fonts
            |   |-- fontawesome-webfont.eot
            |   |-- fontawesome-webfont.svg
            |   |-- fontawesome-webfont.ttf
            |   |-- fontawesome-webfont.woff
            |   |-- fontawesome-webfont.woff2
            |   |-- FontAwesome.otf
            |   |-- glyphicons-halflings-regular.eot
            |   |-- glyphicons-halflings-regular.svg
            |   |-- glyphicons-halflings-regular.ttf
            |   |-- glyphicons-halflings-regular.woff
            |   |-- glyphicons-halflings-regular.woff2
            |   |-- TaurusNormal.svg
            |   |-- TaurusNormal.ttf
            |   |-- TaurusNormal.woff
            |-- images
            |   |-- asd.jpg
            |   |-- backtop.png
            |   |-- bg.jpg
            |   |-- browser.jpg
            |   |-- chart.png
            |   |-- excerpt.jpg
            |   |-- loading.gif
            |   |-- logo.png
            |   |-- news-icon.png
            |   |-- occupying.png
            |   |-- sdjtu.png
            |   |-- sdjtu2.png
            |   |-- weixin.jpg
            |   |-- icon
            |   |   |-- favicon.ico
            |   |   |-- favicon.png
            |   |   |-- favicon.psd
            |   |   |-- icon.png
            |   |   |-- icon.psd
            |   |-- snow
            |       |-- snow0.gif
            |       |-- snow1.gif
            |       |-- snow2.gif
            |       |-- snow3.gif
            |-- js
            |   |-- admin-scripts.js
            |   |-- bootstrap.min.js
            |   |-- Chart.min.js
            |   |-- chartinator.js
            |   |-- fileinput.js
            |   |-- fileinput.min.js
            |   |-- html5shiv.min.js
            |   |-- jquery-2.1.4.min.js
            |   |-- respond.min.js
            |   |-- selectivizr-min.js
            |-- lib
            |   |-- summernote
            |   |   |-- summernote.css
            |   |   |-- summernote.js
            |   |   |-- summernote.min.js
            |   |   |-- lang
            |   |       |-- summernote-ar-AR.js
            |   |       |-- summernote-ar-AR.min.js
            |   |       |-- summernote-bg-BG.js
            |   |       |-- summernote-bg-BG.min.js
            |   |       |-- summernote-ca-ES.js
            |   |       |-- summernote-ca-ES.min.js
            |   |       |-- summernote-cs-CZ.js
            |   |       |-- summernote-cs-CZ.min.js
            |   |       |-- summernote-da-DK.js
            |   |       |-- summernote-da-DK.min.js
            |   |       |-- summernote-de-DE.js
            |   |       |-- summernote-de-DE.min.js
            |   |       |-- summernote-es-ES.js
            |   |       |-- summernote-es-ES.min.js
            |   |       |-- summernote-es-EU.js
            |   |       |-- summernote-es-EU.min.js
            |   |       |-- summernote-fa-IR.js
            |   |       |-- summernote-fa-IR.min.js
            |   |       |-- summernote-fi-FI.js
            |   |       |-- summernote-fi-FI.min.js
            |   |       |-- summernote-fr-FR.js
            |   |       |-- summernote-fr-FR.min.js
            |   |       |-- summernote-he-IL.js
            |   |       |-- summernote-he-IL.min.js
            |   |       |-- summernote-hu-HU.js
            |   |       |-- summernote-hu-HU.min.js
            |   |       |-- summernote-id-ID.js
            |   |       |-- summernote-id-ID.min.js
            |   |       |-- summernote-it-IT.js
            |   |       |-- summernote-it-IT.min.js
            |   |       |-- summernote-ja-JP.js
            |   |       |-- summernote-ja-JP.min.js
            |   |       |-- summernote-ko-KR.js
            |   |       |-- summernote-ko-KR.min.js
            |   |       |-- summernote-lt-LT.js
            |   |       |-- summernote-lt-LT.min.js
            |   |       |-- summernote-nb-NO.js
            |   |       |-- summernote-nb-NO.min.js
            |   |       |-- summernote-nl-NL.js
            |   |       |-- summernote-nl-NL.min.js
            |   |       |-- summernote-pl-PL.js
            |   |       |-- summernote-pl-PL.min.js
            |   |       |-- summernote-pt-BR.js
            |   |       |-- summernote-pt-BR.min.js
            |   |       |-- summernote-pt-PT.js
            |   |       |-- summernote-pt-PT.min.js
            |   |       |-- summernote-ro-RO.js
            |   |       |-- summernote-ro-RO.min.js
            |   |       |-- summernote-ru-RU.js
            |   |       |-- summernote-ru-RU.min.js
            |   |       |-- summernote-sk-SK.js
            |   |       |-- summernote-sk-SK.min.js
            |   |       |-- summernote-sl-SI.js
            |   |       |-- summernote-sl-SI.min.js
            |   |       |-- summernote-sr-RS-Latin.js
            |   |       |-- summernote-sr-RS-Latin.min.js
            |   |       |-- summernote-sr-RS.js
            |   |       |-- summernote-sr-RS.min.js
            |   |       |-- summernote-sv-SE.js
            |   |       |-- summernote-sv-SE.min.js
            |   |       |-- summernote-th-TH.js
            |   |       |-- summernote-th-TH.min.js
            |   |       |-- summernote-tr-TR.js
            |   |       |-- summernote-tr-TR.min.js
            |   |       |-- summernote-uk-UA.js
            |   |       |-- summernote-uk-UA.min.js
            |   |       |-- summernote-vi-VN.js
            |   |       |-- summernote-vi-VN.min.js
            |   |       |-- summernote-zh-CN.js
            |   |       |-- summernote-zh-CN.min.js
            |   |       |-- summernote-zh-TW.js
            |   |       |-- summernote-zh-TW.min.js
            |   |-- ueditor
            |       |-- index.html
            |       |-- ueditor.all.js
            |       |-- ueditor.all.min.js
            |       |-- ueditor.config.js
            |       |-- ueditor.parse.js
            |       |-- ueditor.parse.min.js
            |       |-- dialogs
            |       |   |-- internal.js
            |       |   |-- anchor
            |       |   |   |-- anchor.html
            |       |   |-- attachment
            |       |   |   |-- attachment.css
            |       |   |   |-- attachment.html
            |       |   |   |-- attachment.js
            |       |   |   |-- fileTypeImages
            |       |   |   |   |-- icon_chm.gif
            |       |   |   |   |-- icon_default.png
            |       |   |   |   |-- icon_doc.gif
            |       |   |   |   |-- icon_exe.gif
            |       |   |   |   |-- icon_jpg.gif
            |       |   |   |   |-- icon_mp3.gif
            |       |   |   |   |-- icon_mv.gif
            |       |   |   |   |-- icon_pdf.gif
            |       |   |   |   |-- icon_ppt.gif
            |       |   |   |   |-- icon_psd.gif
            |       |   |   |   |-- icon_rar.gif
            |       |   |   |   |-- icon_txt.gif
            |       |   |   |   |-- icon_xls.gif
            |       |   |   |-- images
            |       |   |       |-- alignicon.gif
            |       |   |       |-- alignicon.png
            |       |   |       |-- bg.png
            |       |   |       |-- file-icons.gif
            |       |   |       |-- file-icons.png
            |       |   |       |-- icons.gif
            |       |   |       |-- icons.png
            |       |   |       |-- image.png
            |       |   |       |-- progress.png
            |       |   |       |-- success.gif
            |       |   |       |-- success.png
            |       |   |-- background
            |       |   |   |-- background.css
            |       |   |   |-- background.html
            |       |   |   |-- background.js
            |       |   |   |-- images
            |       |   |       |-- bg.png
            |       |   |       |-- success.png
            |       |   |-- charts
            |       |   |   |-- chart.config.js
            |       |   |   |-- charts.css
            |       |   |   |-- charts.html
            |       |   |   |-- charts.js
            |       |   |   |-- images
            |       |   |       |-- charts0.png
            |       |   |       |-- charts1.png
            |       |   |       |-- charts2.png
            |       |   |       |-- charts3.png
            |       |   |       |-- charts4.png
            |       |   |       |-- charts5.png
            |       |   |-- emotion
            |       |   |   |-- emotion.css
            |       |   |   |-- emotion.html
            |       |   |   |-- emotion.js
            |       |   |   |-- images
            |       |   |       |-- 0.gif
            |       |   |       |-- bface.gif
            |       |   |       |-- cface.gif
            |       |   |       |-- fface.gif
            |       |   |       |-- jxface2.gif
            |       |   |       |-- neweditor-tab-bg.png
            |       |   |       |-- tface.gif
            |       |   |       |-- wface.gif
            |       |   |       |-- yface.gif
            |       |   |-- gmap
            |       |   |   |-- gmap.html
            |       |   |-- help
            |       |   |   |-- help.css
            |       |   |   |-- help.html
            |       |   |   |-- help.js
            |       |   |-- image
            |       |   |   |-- image.css
            |       |   |   |-- image.html
            |       |   |   |-- image.js
            |       |   |   |-- images
            |       |   |       |-- alignicon.jpg
            |       |   |       |-- bg.png
            |       |   |       |-- icons.gif
            |       |   |       |-- icons.png
            |       |   |       |-- image.png
            |       |   |       |-- progress.png
            |       |   |       |-- success.gif
            |       |   |       |-- success.png
            |       |   |-- insertframe
            |       |   |   |-- insertframe.html
            |       |   |-- link
            |       |   |   |-- link.html
            |       |   |-- map
            |       |   |   |-- map.html
            |       |   |   |-- show.html
            |       |   |-- music
            |       |   |   |-- music.css
            |       |   |   |-- music.html
            |       |   |   |-- music.js
            |       |   |-- preview
            |       |   |   |-- preview.html
            |       |   |-- scrawl
            |       |   |   |-- scrawl.css
            |       |   |   |-- scrawl.html
            |       |   |   |-- scrawl.js
            |       |   |   |-- images
            |       |   |       |-- addimg.png
            |       |   |       |-- brush.png
            |       |   |       |-- delimg.png
            |       |   |       |-- delimgH.png
            |       |   |       |-- empty.png
            |       |   |       |-- emptyH.png
            |       |   |       |-- eraser.png
            |       |   |       |-- redo.png
            |       |   |       |-- redoH.png
            |       |   |       |-- scale.png
            |       |   |       |-- scaleH.png
            |       |   |       |-- size.png
            |       |   |       |-- undo.png
            |       |   |       |-- undoH.png
            |       |   |-- searchreplace
            |       |   |   |-- searchreplace.html
            |       |   |   |-- searchreplace.js
            |       |   |-- snapscreen
            |       |   |   |-- snapscreen.html
            |       |   |-- spechars
            |       |   |   |-- spechars.html
            |       |   |   |-- spechars.js
            |       |   |-- table
            |       |   |   |-- dragicon.png
            |       |   |   |-- edittable.css
            |       |   |   |-- edittable.html
            |       |   |   |-- edittable.js
            |       |   |   |-- edittd.html
            |       |   |   |-- edittip.html
            |       |   |-- template
            |       |   |   |-- config.js
            |       |   |   |-- template.css
            |       |   |   |-- template.html
            |       |   |   |-- template.js
            |       |   |   |-- images
            |       |   |       |-- bg.gif
            |       |   |       |-- pre0.png
            |       |   |       |-- pre1.png
            |       |   |       |-- pre2.png
            |       |   |       |-- pre3.png
            |       |   |       |-- pre4.png
            |       |   |-- video
            |       |   |   |-- video.css
            |       |   |   |-- video.html
            |       |   |   |-- video.js
            |       |   |   |-- images
            |       |   |       |-- bg.png
            |       |   |       |-- center_focus.jpg
            |       |   |       |-- file-icons.gif
            |       |   |       |-- file-icons.png
            |       |   |       |-- icons.gif
            |       |   |       |-- icons.png
            |       |   |       |-- image.png
            |       |   |       |-- left_focus.jpg
            |       |   |       |-- none_focus.jpg
            |       |   |       |-- progress.png
            |       |   |       |-- right_focus.jpg
            |       |   |       |-- success.gif
            |       |   |       |-- success.png
            |       |   |-- webapp
            |       |   |   |-- webapp.html
            |       |   |-- wordimage
            |       |       |-- fClipboard_ueditor.swf
            |       |       |-- imageUploader.swf
            |       |       |-- tangram.js
            |       |       |-- wordimage.html
            |       |       |-- wordimage.js
            |       |-- lang
            |       |   |-- en
            |       |   |   |-- en.js
            |       |   |   |-- images
            |       |   |       |-- addimage.png
            |       |   |       |-- alldeletebtnhoverskin.png
            |       |   |       |-- alldeletebtnupskin.png
            |       |   |       |-- background.png
            |       |   |       |-- button.png
            |       |   |       |-- copy.png
            |       |   |       |-- deletedisable.png
            |       |   |       |-- deleteenable.png
            |       |   |       |-- listbackground.png
            |       |   |       |-- localimage.png
            |       |   |       |-- music.png
            |       |   |       |-- rotateleftdisable.png
            |       |   |       |-- rotateleftenable.png
            |       |   |       |-- rotaterightdisable.png
            |       |   |       |-- rotaterightenable.png
            |       |   |       |-- upload.png
            |       |   |-- zh-cn
            |       |       |-- zh-cn.js
            |       |       |-- images
            |       |           |-- copy.png
            |       |           |-- localimage.png
            |       |           |-- music.png
            |       |           |-- upload.png
            |       |-- php
            |       |   |-- action_crawler.php
            |       |   |-- action_list.php
            |       |   |-- action_upload.php
            |       |   |-- config.json
            |       |   |-- controller.php
            |       |   |-- Uploader.class.php
            |       |-- themes
            |       |   |-- iframe.css
            |       |   |-- default
            |       |       |-- dialogbase.css
            |       |       |-- css
            |       |       |   |-- ueditor.css
            |       |       |   |-- ueditor.min.css
            |       |       |-- images
            |       |           |-- anchor.gif
            |       |           |-- arrow.png
            |       |           |-- arrow_down.png
            |       |           |-- arrow_up.png
            |       |           |-- button-bg.gif
            |       |           |-- cancelbutton.gif
            |       |           |-- charts.png
            |       |           |-- cursor_h.gif
            |       |           |-- cursor_h.png
            |       |           |-- cursor_v.gif
            |       |           |-- cursor_v.png
            |       |           |-- dialog-title-bg.png
            |       |           |-- filescan.png
            |       |           |-- highlighted.gif
            |       |           |-- icons-all.gif
            |       |           |-- icons.gif
            |       |           |-- icons.png
            |       |           |-- loaderror.png
            |       |           |-- loading.gif
            |       |           |-- lock.gif
            |       |           |-- neweditor-tab-bg.png
            |       |           |-- pagebreak.gif
            |       |           |-- scale.png
            |       |           |-- sortable.png
            |       |           |-- spacer.gif
            |       |           |-- sparator_v.png
            |       |           |-- table-cell-align.png
            |       |           |-- tangram-colorpicker.png
            |       |           |-- toolbar_bg.png
            |       |           |-- unhighlighted.gif
            |       |           |-- upload.png
            |       |           |-- videologo.gif
            |       |           |-- word.gif
            |       |           |-- wordpaste.png
            |       |-- third-party
            |           |-- jquery-1.10.2.js
            |           |-- jquery-1.10.2.min.js
            |           |-- jquery-1.10.2.min.map
            |           |-- codemirror
            |           |   |-- codemirror.css
            |           |   |-- codemirror.js
            |           |-- highcharts
            |           |   |-- highcharts-more.js
            |           |   |-- highcharts-more.src.js
            |           |   |-- highcharts.js
            |           |   |-- highcharts.src.js
            |           |   |-- adapters
            |           |   |   |-- mootools-adapter.js
            |           |   |   |-- mootools-adapter.src.js
            |           |   |   |-- prototype-adapter.js
            |           |   |   |-- prototype-adapter.src.js
            |           |   |   |-- standalone-framework.js
            |           |   |   |-- standalone-framework.src.js
            |           |   |-- modules
            |           |   |   |-- annotations.js
            |           |   |   |-- annotations.src.js
            |           |   |   |-- canvas-tools.js
            |           |   |   |-- canvas-tools.src.js
            |           |   |   |-- data.js
            |           |   |   |-- data.src.js
            |           |   |   |-- drilldown.js
            |           |   |   |-- drilldown.src.js
            |           |   |   |-- exporting.js
            |           |   |   |-- exporting.src.js
            |           |   |   |-- funnel.js
            |           |   |   |-- funnel.src.js
            |           |   |   |-- heatmap.js
            |           |   |   |-- heatmap.src.js
            |           |   |   |-- map.js
            |           |   |   |-- map.src.js
            |           |   |   |-- no-data-to-display.js
            |           |   |   |-- no-data-to-display.src.js
            |           |   |-- themes
            |           |       |-- dark-blue.js
            |           |       |-- dark-green.js
            |           |       |-- gray.js
            |           |       |-- grid.js
            |           |       |-- skies.js
            |           |-- snapscreen
            |           |   |-- UEditorSnapscreen.exe
            |           |-- SyntaxHighlighter
            |           |   |-- shCore.js
            |           |   |-- shCoreDefault.css
            |           |-- video-js
            |           |   |-- video-js.css
            |           |   |-- video-js.min.css
            |           |   |-- video-js.swf
            |           |   |-- video.dev.js
            |           |   |-- video.js
            |           |   |-- font
            |           |       |-- vjs.eot
            |           |       |-- vjs.svg
            |           |       |-- vjs.ttf
            |           |       |-- vjs.woff
            |           |-- webuploader
            |           |   |-- Uploader.swf
            |           |   |-- webuploader.css
            |           |   |-- webuploader.custom.js
            |           |   |-- webuploader.custom.min.js
            |           |   |-- webuploader.flashonly.js
            |           |   |-- webuploader.flashonly.min.js
            |           |   |-- webuploader.html5only.js
            |           |   |-- webuploader.html5only.min.js
            |           |   |-- webuploader.js
            |           |   |-- webuploader.min.js
            |           |   |-- webuploader.withoutimage.js
            |           |   |-- webuploader.withoutimage.min.js
            |           |-- zeroclipboard
            |               |-- ZeroClipboard.js
            |               |-- ZeroClipboard.min.js
            |               |-- ZeroClipboard.swf
            |-- template
            |   |-- userExporTemplate.xls
            |-- user
            |   |-- book_room.jsp
            |   |-- header.jsp
            |   |-- login.jsp
            |   |-- main_user.jsp
            |   |-- meet.jsp
            |   |-- order.jsp
            |   |-- pwd.jsp
            |   |-- css
            |   |   |-- animate.css
            |   |   |-- animate.min.css
            |   |   |-- bootstrap.css
            |   |   |-- bootstrap.min.css
            |   |   |-- jquery-ui.css
            |   |   |-- prettify.css
            |   |   |-- prettify.min.css
            |   |   |-- style-gantt.css
            |   |   |-- style.css
            |   |   |-- style1.css
            |   |-- fonts
            |   |   |-- glyphicons-halflings-regular.eot
            |   |   |-- glyphicons-halflings-regular.svg
            |   |   |-- glyphicons-halflings-regular.ttf
            |   |   |-- glyphicons-halflings-regular.woff
            |   |   |-- glyphicons-halflings-regular.woff2
            |   |   |-- icomoon
            |   |       |-- icomoon.eot
            |   |       |-- icomoon.svg
            |   |       |-- icomoon.ttf
            |   |       |-- icomoon.woff
            |   |-- images
            |   |   |-- 1-.png
            |   |   |-- 1.png
            |   |   |-- 2.png
            |   |   |-- 3.png
            |   |   |-- 4.png
            |   |   |-- banner.jpg
            |   |   |-- banner1.jpg
            |   |   |-- bg_2.jpg
            |   |   |-- close.png
            |   |   |-- geometry2.png
            |   |   |-- grid.png
            |   |   |-- icon_sprite.png
            |   |   |-- img-sp.png
            |   |   |-- loader_bg.png
            |   |   |-- slider_handle.png
            |   |-- js
            |   |   |-- bootstrap.js
            |   |   |-- bootstrap.min.js
            |   |   |-- jquery-1.11.1.min.js
            |   |   |-- jquery-2.1.4.min.js
            |   |   |-- jquery-ui.js
            |   |   |-- jquery.fn.gantt.js
            |   |   |-- jquery.min.js
            |   |   |-- jquery.placeholder.min.js
            |   |   |-- jquery.waypoints.min.js
            |   |   |-- main.js
            |   |   |-- menu_jquery.js
            |   |   |-- modernizr-2.6.2.min.js
            |   |   |-- prettify.js
            |   |   |-- prettify.min.js
            |   |   |-- respond.min.js
            |   |   |-- wow.min.js
            |   |-- sass
            |       |-- style.scss
            |-- WEB-INF
                |-- web.xml
