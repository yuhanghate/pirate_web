package com.yuhang.novel.pirate.constant;

/**
 * 书源
 */
public class BookResouceConstant {

    /**
     * 书源地址
     */
    public static final String RESOUCE_URL = "http://ku.iszoc.com";

    public static final String TEST_HTML_DETAILS = "<html><head>\n" +
            "    <meta charset=\"utf-8\">\n" +
            "    <title>阅读酷 - 书源在线分享平台</title>\n" +
            "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1\">\n" +
            "    <meta name=\"keywords\" content=\"阅读app,免费小说阅读器,阅读书源\">\n" +
            "    <meta name=\"description\" content=\"阅读酷是基于安卓免费小说阅读器《阅读》开发的在线书源分享平台。\">\n" +
            "    <link rel=\"stylesheet\" href=\"/static/plugins/layui/css/layui.css\">\n" +
            "    <link rel=\"stylesheet\" href=\"/static/index/css/common.css\"> \n" +
            "    <link rel=\"stylesheet\" href=\"/static/plugins/AdminLTE/bower_components/font-awesome/css/font-awesome.min.css\">\n" +
            "    <script src=\"https://hm.baidu.com/hm.js?ea5e026ac2ed0205ce7a6417bbd1dcef\"></script><script src=\"/static/index/js/jquery.js\"></script>   \n" +
            "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\">\n" +
            "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1\">\n" +
            "    <meta name=\"apple-mobile-web-app-status-bar-style\" content=\"black\">\n" +
            "    <meta name=\"apple-mobile-web-app-capable\" content=\"yes\">\n" +
            "    <meta name=\"format-detection\" content=\"telephone=no\">\n" +
            "    <style>\n" +
            "        .layui-form-select{\n" +
            "            color:black;\n" +
            "        }\n" +
            "    </style><link id=\"layuicss-layer\" rel=\"stylesheet\" href=\"http://ku.iszoc.com/static/plugins/layui/css/modules/layer/default/layer.css?v=3.1.1\" media=\"all\"></head>\n" +
            "    \n" +
            "<body>     \n" +
            "<div class=\"layui-header header header-index\">\n" +
            "    <div class=\"layui-main\">\n" +
            "        <a class=\"logo\" href=\"/index/search.html\"></a>\n" +
            "        <ul class=\"layui-nav\">        \n" +
            "           <!--  <li class=\"layui-nav-item\" style=\"padding:0px;\">\n" +
            "                <a href=\"javascript:;\">排行榜单</a>\n" +
            "                <dl class=\"layui-nav-child layui-anim layui-anim-upbit\">\n" +
            "                    <dd lay-unselect=\"\">\n" +
            "                        <a>开发中</a>\n" +
            "                    </dd>\n" +
            "                    <dd lay-unselect=\"\">\n" +
            "                        <a href=\"\" target=\"_blank\">收藏榜</a>\n" +
            "                    </dd>\n" +
            "                    <dd lay-unselect=\"\">\n" +
            "                        <a href=\"\" target=\"_blank\">评分榜</a>\n" +
            "                    </dd>\n" +
            "                </dl>\n" +
            "            </li>  -->\n" +
            "            <li class=\"layui-nav-item\" style=\"padding:0px;\">\n" +
            "                 <a style=\"padding:0px 8px;\" href=\"/index/article/index.html\">\n" +
            "                    <i class=\"fa fa-newspaper-o\"></i>&nbsp;&nbsp;资讯中心\n" +
            "                </a>\n" +
            "            </li>\n" +
            "                        <li class=\"layui-nav-item\" style=\"padding:0px;\">\n" +
            "                 <a href=\"/index/sns/login.html\"><i class=\"fa fa-qq\"></i>&nbsp;&nbsp;登 陆</a> \n" +
            "            </li>\n" +
            "                    <span class=\"layui-nav-bar\"></span></ul>\n" +
            "    </div>\n" +
            "</div>\n" +
            "\n" +
            "<style>\n" +
            "   body{\n" +
            "    background-color: #f2f2f2;\n" +
            "   }\n" +
            "</style>\n" +
            "<div class=\"layui-container\">\n" +
            "    <div class=\"layui-card source-card\">\n" +
            "        <div class=\"layui-card-header\" style=\"padding-top:15px;\">\n" +
            "            <fieldset class=\"layui-elem-field layui-field-title layui-input-inline\" style=\"margin:0 5px;\">\n" +
            "                <legend style=\"margin-left:0px;\">\n" +
            "                    <b>\n" +
            "                        <!-- <i class=\"layui-icon layui-icon-read\" style=\"font-size:23px;position:relative;top:1px;\"></i> -->\n" +
            "                        <img class=\"icon_img\" src=\"https://ico.mikelin.cn/https://allcp.net\">\n" +
            "                        长佩论坛手机版                    </b>\n" +
            "                                             <span onclick=\"sign(this,1629,'yes')\" title=\"未收藏\" style=\"cursor:pointer;\">   <i class=\"layui-icon layui-icon-star\" style=\"font-size: 20px;\"></i>\n" +
            "                         </span>\n" +
            "                                    </legend>\n" +
            "            </fieldset>\n" +
            "            <a id=\"getShotUrl\" class=\"layui-btn layui-btn-normal\" style=\"float:right;\" data-clipboard-text=\"\"><i class=\"layui-icon\">\uE641</i> 分 享</a>\n" +
            "        </div>\n" +
            "        <div class=\"layui-card-body\" style=\"padding:15px;\">\n" +
            "            <div class=\"layui-form layui-form-pane\">\n" +
            "                <div class=\"layui-form-item\">\n" +
            "                    <label class=\"layui-form-label\">\n" +
            "                        <i class=\"layui-icon layui-icon-read\"></i>\n" +
            "                        书源名称\n" +
            "                    </label>\n" +
            "                    <div class=\"layui-input-inline\">\n" +
            "                        <input class=\"layui-input\" readonly=\"\" type=\"text\" value=\"长佩论坛手机版\" data-cip-id=\"cIPJQ342845639\">\n" +
            "                        \n" +
            "                    </div>\n" +
            "                    <label class=\"layui-form-label\">\n" +
            "                        <i class=\"layui-icon layui-icon-username\"></i>\n" +
            "                        书源作者\n" +
            "                    </label>\n" +
            "                    <div class=\"layui-input-inline\">\n" +
            "                        <input class=\"layui-input\" readonly=\"\" type=\"text\" value=\"天天gg\" data-cip-id=\"cIPJQ342845640\">\n" +
            "                        \n" +
            "                    </div>\n" +
            "                    <label class=\"layui-form-label\">\n" +
            "                        <i class=\"layui-icon layui-icon-upload-drag\"></i>\n" +
            "                        更新时间\n" +
            "                    </label>\n" +
            "                    <div class=\"layui-input-inline\">\n" +
            "                        <input class=\"layui-input\" readonly=\"\" type=\"text\" value=\"2019-09-28 00:22:56\" data-cip-id=\"cIPJQ342845641\">\n" +
            "                        \n" +
            "                    </div>\n" +
            "                </div>\n" +
            "                <div class=\"layui-form-item\">\n" +
            "                    <label class=\"layui-form-label\">\n" +
            "                        <i class=\"layui-icon layui-icon-unlink\"></i>\n" +
            "                        书源网址\n" +
            "                    </label>\n" +
            "                    <div class=\"layui-input-inline\">\n" +
            "                        <input class=\"layui-input\" id=\"url\" readonly=\"\" type=\"text\" value=\"https://allcp.net\" data-cip-id=\"url\">\n" +
            "                        \n" +
            "                    </div>\n" +
            "                    <label class=\"layui-form-label\">\n" +
            "                        <i class=\"layui-icon layui-icon-tips\"></i>\n" +
            "                        网站状态\n" +
            "                    </label>\n" +
            "                    <div class=\"layui-input-inline\">\n" +
            "                        <div class=\"layui-input\" style=\"line-height:36px;\">\n" +
            "                                                        <span style=\"font-weight:bold;color:red;font-family:黑体;\" id=\"status\">\n" +
            "                                无法访问\n" +
            "                            </span>\n" +
            "                                                    </div>\n" +
            "                    </div>\n" +
            "                    <label class=\"layui-form-label\">\n" +
            "                        <i class=\"layui-icon layui-icon-refresh-1\"></i>\n" +
            "                        检测时间\n" +
            "                    </label>\n" +
            "                    <div class=\"layui-input-inline\">\n" +
            "                                                 <input class=\"layui-input\" readonly=\"\" type=\"text\" value=\"2019-10-02 03:45:10\" data-cip-id=\"cIPJQ342845642\">\n" +
            "                        \n" +
            "                                            </div>\n" +
            "                </div>\n" +
            "                <div class=\"layui-form-item layui-form-text\">\n" +
            "                                             <span class=\"layui-badge-rim\" style=\"height:30px;line-height:30px;font-size:14px;\"><i class=\"layui-icon layui-icon-search\"></i>  带发现</span>\n" +
            "                                    </div>\n" +
            "                                <div class=\"layui-form-item layui-form-text\">\n" +
            "                    <label class=\"layui-form-label\">\n" +
            "                        <i class=\"layui-icon layui-icon-notice\"></i>\n" +
            "                        书源说明\n" +
            "                    </label>\n" +
            "                    <div class=\"layui-input-block book_desc\">\n" +
            "                        <div>\n" +
            "                            <ul>\n" +
            "\t<li>源站已被GFW</li>\n" +
            "\t<li>不支持搜索</li>\n" +
            "</ul>\n" +
            "                        </div>\n" +
            "                    </div>\n" +
            "                </div>\n" +
            "                                <div class=\"layui-form-item layui-form-text\">\n" +
            "                    <label class=\"layui-form-label\">\n" +
            "                        <i class=\"layui-icon layui-icon-chat\"></i>\n" +
            "                        官方提示\n" +
            "                    </label>\n" +
            "                    <div class=\"layui-input-block book_desc\">\n" +
            "                        <div>\n" +
            "                            <span>\n" +
            "                                <p><strong>1. </strong>网站状态结果仅供参考，网站不一定失效，可能只是暂时抽风。</p>\n" +
            "\n" +
            "<p><strong>2. </strong>由于某些书源信息太多无法生成二维码，因此数据较大的书源未生成二维码，请手动点击下方的&lt;复制书源&gt;，然后手动导入。</p>\n" +
            "\n" +
            "<p><strong>3.</strong>&nbsp;如果不知如何导入书源，具体可查看本站教程 :&nbsp;<a href=\"http://ku.iszoc.com/index/article/detail/1.html\"><u><strong><span style=\"color:#e74c3c;\">书源导入小技巧</span></strong></u></a>&nbsp;</p>\n" +
            " \n" +
            "                            </span>\n" +
            "                        </div>\n" +
            "                    </div>\n" +
            "                </div>\n" +
            "                <div class=\"layui-form-item layui-form-text\">\n" +
            "                    <label class=\"layui-form-label\">\n" +
            "                        <i class=\"layui-icon layui-icon-picture\"></i>\n" +
            "                        书源二维码\n" +
            "                        <botton class=\"layui-btn layui-btn-danger layui-btn-sm code_copy\" id=\"copy\" data-clipboard-target=\"#showjson\">\n" +
            "                            <i class=\"layui-icon layui-icon-file-b\"></i>\n" +
            "                            复制书源代码\n" +
            "                        </botton>\n" +
            "                    </label>\n" +
            "                    <div class=\"layui-input-block qrcode_f\">\n" +
            "                                                    <img src=\"http://cloud.iszoc.com/booksource/qrcode/YueDu1629-1569600955.png\" alt=\"长佩论坛手机版\" title=\"长佩论坛手机版\">\n" +
            "                                            </div>\n" +
            "                </div>\n" +
            "                <div class=\"layui-collapse\">\n" +
            "                    <div class=\"layui-colla-item\">\n" +
            "                        <h2 class=\"layui-colla-title code_content\">\n" +
            "                            书源代码 (<b style=\"color:red;\">点击展开</b>)\n" +
            "                        <i class=\"layui-icon layui-colla-icon\">\uE602</i></h2>\n" +
            "                        <div class=\"layui-colla-content\" id=\"showjson\">\n" +
            "                            <pre class=\"layui-code\">{\n" +
            "  \"bookSourceGroup\": \"发现; 测试; 科学上网\",\n" +
            "  \"bookSourceName\": \"长佩论坛手机版\",\n" +
            "  \"bookSourceUrl\": \"https://allcp.net\",\n" +
            "  \"enable\": false,\n" +
            "  \"httpUserAgent\": \"Mozilla/5.0 (Android 10; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.73 Safari/537.36\",\n" +
            "  \"loginUrl\": \"\",\n" +
            "  \"ruleBookAuthor\": \"class.grey.0@a@text\",\n" +
            "  \"ruleBookContent\": \"class.plc cl@class.message@textNodes\",\n" +
            "  \"ruleBookInfoInit\": \"\",\n" +
            "  \"ruleBookKind\": \".postlist@h2@text##\\\\[(.*)\\\\].*楼主##$1###\",\n" +
            "  \"ruleBookLastChapter\": \"class.message.0@.pstatus@text\",\n" +
            "  \"ruleBookName\": \".postlist@h2@text##\\\\[.*\\\\]\\\\s+(.*)\\\\s+只看楼主##$1###\",\n" +
            "  \"ruleBookUrlPattern\": \"\",\n" +
            "  \"ruleChapterList\": \".postlist@h2@a\",\n" +
            "  \"ruleChapterName\": \"text\",\n" +
            "  \"ruleChapterUrl\": \"\",\n" +
            "  \"ruleChapterUrlNext\": \"\",\n" +
            "  \"ruleContentUrl\": \"href\",\n" +
            "  \"ruleContentUrlNext\": \"class.pg@tag.a.-1@href\",\n" +
            "  \"ruleCoverUrl\": \"\",\n" +
            "  \"ruleFindAuthor\": \"a@span@text\",\n" +
            "  \"ruleFindIntroduce\": \"\",\n" +
            "  \"ruleFindKind\": \"\",\n" +
            "  \"ruleFindList\": \"//li[span[img]][last()]/following-sibling::li[a[span[text()!=\\\"\\\"]]]\",\n" +
            "  \"ruleFindName\": \"a@textNodes\",\n" +
            "  \"ruleFindNoteUrl\": \"a@href\",\n" +
            "  \"ruleFindUrl\": \"原创文窟(已被G*F*W)::https://allcp.net/forum.php?mod=forumdisplay&amp;fid=4&amp;sortid=8&amp;mobile=2&amp;sortid=8&amp;page=searchPage\",\n" +
            "  \"ruleIntroduce\": \"\",\n" +
            "  \"ruleSearchAuthor\": \"\",\n" +
            "  \"ruleSearchCoverUrl\": \"\",\n" +
            "  \"ruleSearchIntroduce\": \"\",\n" +
            "  \"ruleSearchKind\": \"\",\n" +
            "  \"ruleSearchLastChapter\": \"\",\n" +
            "  \"ruleSearchList\": \"\",\n" +
            "  \"ruleSearchName\": \"\",\n" +
            "  \"ruleSearchNoteUrl\": \"\",\n" +
            "  \"ruleSearchUrl\": \"\",\n" +
            "  \"serialNumber\": 0,\n" +
            "  \"weight\": 0\n" +
            "}</pre>\n" +
            "                        </div>\n" +
            "                    </div>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "\n" +
            "\n" +
            "        <!--评论-->\n" +
            "        <fieldset class=\"layui-elem-field\" style=\"margin:0 15px 15px\">\n" +
            "            <legend style=\"font-size:14px;\">\n" +
            "                <i class=\"fa fa-comments-o\"></i> \n" +
            "                书源评论（共 0 条）\n" +
            "            </legend>\n" +
            "            <div class=\"layui-field-box\">\n" +
            "                                <p style=\"text-align: center;font-size:14px;\">还没有人评论哦~</p>\n" +
            "                            </div>\n" +
            "        </fieldset>\n" +
            "        <div style=\"padding-left:10px;\">\n" +
            "                     </div>\n" +
            "        <!--评论-->\n" +
            "        <div style=\"padding:0 15px 15px 15px;margin-bottom:15px;\">\n" +
            "            <form action=\"\" method=\"post\">\n" +
            "                <input type=\"hidden\" name=\"bid\" value=\"1629\" id=\"bid\">\n" +
            "                <textarea class=\"layui-textarea layui-hide\" id=\"content\" lay-verify=\"content\" name=\"content\" style=\"display: none\"></textarea><div class=\"layui-layedit\"><div class=\"layui-unselect layui-layedit-tool\"><i class=\"layui-icon layedit-tool-b\" title=\"加粗\" lay-command=\"Bold\" layedit-event=\"b\" \"=\"\">\uE62B</i><i class=\"layui-icon layedit-tool-i\" title=\"斜体\" lay-command=\"italic\" layedit-event=\"i\" \"=\"\">\uE644</i><i class=\"layui-icon layedit-tool-u\" title=\"下划线\" lay-command=\"underline\" layedit-event=\"u\" \"=\"\">\uE646</i><i class=\"layui-icon layedit-tool-d\" title=\"删除线\" lay-command=\"strikeThrough\" layedit-event=\"d\" \"=\"\">\uE64F</i><i class=\"layui-icon layedit-tool-left\" title=\"左对齐\" lay-command=\"justifyLeft\" layedit-event=\"left\" \"=\"\">\uE649</i><i class=\"layui-icon layedit-tool-center\" title=\"居中对齐\" lay-command=\"justifyCenter\" layedit-event=\"center\" \"=\"\">\uE647</i><i class=\"layui-icon layedit-tool-right\" title=\"右对齐\" lay-command=\"justifyRight\" layedit-event=\"right\" \"=\"\">\uE648</i><i class=\"layui-icon layedit-tool-link\" title=\"插入链接\" layedit-event=\"link\" \"=\"\">\uE64C</i><i class=\"layui-icon layedit-tool-unlink layui-disabled\" title=\"清除链接\" lay-command=\"unlink\" layedit-event=\"unlink\" \"=\"\">\uE64D</i><i class=\"layui-icon layedit-tool-face\" title=\"表情\" layedit-event=\"face\" \"=\"\">\uE650</i></div><div class=\"layui-layedit-iframe\"><iframe id=\"LAY_layedit_1\" name=\"LAY_layedit_1\" textarea=\"content\" frameborder=\"0\" style=\"height: 100px;\"></iframe></div></div>\n" +
            "                <br>\n" +
            "                <button class=\"layui-btn\" lay-submit=\"\" lay-filter=\"up\">\n" +
            "                    <i class=\"layui-icon\">\uE609</i> 发表评论\n" +
            "                </button>\n" +
            "            </form>\n" +
            "            <span style=\"float:right;color:blue;position: relative;bottom:25px;\">\n" +
            "                <a href=\"javascript:(0)\" onclick=\"feedback(this,1629)\" style=\"color:blue;\"><u>该书源有问题,我要反馈</u></a>\n" +
            "            </span>\n" +
            "        </div>\n" +
            "        <!--回复框-->\n" +
            "    </div>\n" +
            "</div>\n" +
            "\n" +
            "<div class=\"layui-footer footer footer-index layui-col-md12\" style=\"padding-top:10px;\">\n" +
            "    <div class=\"layui-main\">\n" +
            "        <p>\n" +
            "            Powered by Hostfans.cn 苏ICP备18007521号-3        </p>\n" +
            "        <p>\n" +
            "            友情链接：\n" +
            "                            <a href=\" https://github.com/gedoor/MyBookshelf\" rel=\"nofollow\" target=\"_blank\"> 阅读のGitHub</a>\n" +
            "                            <a href=\" https://www.hostfans.cn\" rel=\"nofollow\" target=\"_blank\"> 阅读爱好者博客</a>\n" +
            "                    </p>\n" +
            "        <p class=\"site-union\">本站所有资源均为网络采集或网友分享，仅供学习交流！如有侵权请联系网站管理员邮箱：mr_cao#163.com</p>\n" +
            " \n" +
            "    </div>\n" +
            "</div>\n" +
            "<script src=\"/static/plugins/layui/layui.js\"></script>\n" +
            "<!-- <script src=\"/index/js/function.js\"></script>\n" +
            "<script src=\"/index/js/common.js\"></script> -->\n" +
            "<script src=\"/static/index/js/clipboard.min.js\"></script>\n" +
            "<script type=\"text/javascript\">\n" +
            "layui.use(['jquery','layer','form','element'], function(){\n" +
            "    var $ = layui.$, layer = layui.layer, form = layui.form, element = layui.element;\n" +
            "});\n" +
            "\n" +
            "//反馈书源问题\n" +
            "function feedback(obj,id){\n" +
            "    layer.prompt({title: '请输入该书源存在的问题并确认'}, function(val, index){\n" +
            "        $.ajax({\n" +
            "            type: 'POST',\n" +
            "            url: \"/index/feedback.html\",\n" +
            "            dataType: 'json',\n" +
            "            data:{id:id,content:val},\n" +
            "            success: function(data){\n" +
            "              if(data.code==1){\n" +
            "                  layer.msg(data.msg,{icon:1,time:1000});\n" +
            "              }else{\n" +
            "                  layer.msg(data.msg,{icon:2,time:1000});\n" +
            "              }                                 \n" +
            "            }\n" +
            "        });\n" +
            "        layer.close(index);\n" +
            "    });\n" +
            "}\n" +
            "//复制书源代码\n" +
            "$('#copy').click(function(){\n" +
            "    $('#showjson').addClass('layui-show');\n" +
            "    var clipboard = new ClipboardJS('#copy');\n" +
            "    clipboard.on('success', function(e) {\n" +
            "        if(e.text){\n" +
            "            $('#showjson').removeClass('layui-show');\n" +
            "            layer.msg('书源代码已成功复制到剪切板',{icon:1,time:2000});\n" +
            "        }\n" +
            "    });\n" +
            "    clipboard.on('error', function(e) {\n" +
            "        $('#showjson').removeClass('layui-show');\n" +
            "        layer.msg('复制失败,请手动复制',{icon:2,time:2000});\n" +
            "    });\n" +
            "});\n" +
            "\n" +
            "//分享\n" +
            "$('#getShotUrl').click(function(){\n" +
            "    var clipboard = new ClipboardJS('#getShotUrl');\n" +
            "    clipboard.on('success', function(e) {\n" +
            "        if(e.text){\n" +
            "            layer.msg('已复制书源网址到剪切板,赶快去分享吧！',{icon:1,time:3000});\n" +
            "        }\n" +
            "    });\n" +
            "    clipboard.on('error', function(e) {\n" +
            "        layer.msg('复制失败,请手动复制',{icon:2,time:1000});\n" +
            "    });\n" +
            "});\n" +
            "\n" +
            "//收藏\n" +
            "function sign(obj,id,type){\n" +
            "    $.ajax({\n" +
            "        type: 'POST',\n" +
            "        url: \"/index/sign.html\",\n" +
            "        dataType: 'json',\n" +
            "        data:{id:id,type:type},\n" +
            "        success: function(data){\n" +
            "            if(data.code==1){\n" +
            "                layer.msg(data.msg,{icon:1,time:1000},function(){\n" +
            "                    location.reload();\n" +
            "                });\n" +
            "            }else{\n" +
            "                layer.msg(data.msg,{icon:2,time:1000});\n" +
            "            }                                 \n" +
            "        }\n" +
            "    });\n" +
            "}\n" +
            "\n" +
            "//鼠标悬停\n" +
            "function get_css(obj){\n" +
            "    $(obj).css({'box-shadow': '5px 5px 10px rgba(0, 0, 0, 0.1)'});\n" +
            "}\n" +
            "function del_css(obj){\n" +
            "    $(obj).css({'box-shadow':'none'});\n" +
            "}\n" +
            "\n" +
            "//一键导出所有书源\n" +
            "function get_allsource(obj){\n" +
            "    layer.open({\n" +
            "      type: 1,\n" +
            "      skin: 'layui-layer-rim', //加上边框\n" +
            "      area: ['420px', '240px'], //宽高\n" +
            "      content: 'html内容'\n" +
            "    });\n" +
            "}\n" +
            "</script>\n" +
            "<script>\n" +
            "var _hmt = _hmt || [];\n" +
            "(function() {\n" +
            "  var hm = document.createElement(\"script\");\n" +
            "  hm.src = \"https://hm.baidu.com/hm.js?ea5e026ac2ed0205ce7a6417bbd1dcef\";\n" +
            "  var s = document.getElementsByTagName(\"script\")[0]; \n" +
            "  s.parentNode.insertBefore(hm, s);\n" +
            "})();\n" +
            "</script>\n" +
            "<script>\n" +
            "layui.use(['layer','layedit', 'form','jquery'], function(){\n" +
            "    var layer = layui.layer,layedit = layui.layedit,form = layui.form,$ = layui.jquery;\n" +
            "    //创建编辑器\n" +
            "    var editIndex = layedit.build('content',{\n" +
            "        height: 100,\n" +
            "        tool: ['strong','italic','underline','del' ,'left','center','right','link','unlink','face'],\n" +
            "    });\n" +
            "\n" +
            "    form.on('submit(up)', function () {\n" +
            "        var bid = $('#bid').val();\n" +
            "        var content = layedit.getContent(editIndex);\n" +
            "        $.ajax({\n" +
            "            url: \"/index/comments/up.html\",\n" +
            "            data: {content:content,bid:bid},\n" +
            "            type: 'post',\n" +
            "            success: function (res) {\n" +
            "                if (res.error == 1) {\n" +
            "                    layer.msg(res.msg,{icon:1,time:1000},function(index){\n" +
            "                       location.reload();\n" +
            "                    });\n" +
            "                } else {\n" +
            "                    layer.msg(res.msg,{icon:2});\n" +
            "                }\n" +
            "            }\n" +
            "        })\n" +
            "        return false;\n" +
            "    });\n" +
            "\n" +
            "});\n" +
            "//删除评论\n" +
            "function del_comment(obj,id){\n" +
            "    layer.confirm('确定删除当前评论？', {\n" +
            "        btn: ['删除','取消'] //按钮\n" +
            "        }, function(){\n" +
            "           $.ajax({\n" +
            "                type: 'POST',\n" +
            "                url: \"/index/comments/del.html\",\n" +
            "                dataType: 'json',\n" +
            "                data:{id:id},\n" +
            "                success: function(data){\n" +
            "                    if(data.code==1){\n" +
            "                        layer.msg(data.msg,{icon:1,time:1000},function(){\n" +
            "                            $(obj).parents(\"li\").remove();\n" +
            "                        });\n" +
            "                    }else{\n" +
            "                        layer.msg(data.msg,{icon:2,time:1000});\n" +
            "                    }                                 \n" +
            "                }\n" +
            "            });\n" +
            "        }, function(){\n" +
            "\n" +
            "    });\n" +
            "}\n" +
            "</script>\n" +
            "</body></html>";
}
