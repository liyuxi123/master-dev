package com.qxaillm;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractComplaint {
    public static void main(String[] args) {
        String document = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
                + "<uwword fileformat=\"1.1\" xid-max=\"916\" template=\"false\" props=\"document-endnote-place-endsection:0;document-footnote-initial:1;document-footnote-restart-page:0;document-footnote-restart-section:0;document-endnote-restart-section:0;document-endnote-place-enddoc:1;document-footnote-type:numeric;document-endnote-type:numeric;document-endnote-initial:1\">\n"
                + "<metadata>\n"
                + "<m key=\"dc.format\">application/x-uwword</m>\n"
                + "<m key=\"uwword.generator\">uwWord</m>\n"
                + "</metadata>\n"
                + "<styles>\n"
                + "<s type=\"P\" name=\"Normal\" followedby=\"Current Settings\" props=\"margin-top:0pt;margin-left:0pt;widows:2;margin-bottom:0pt;ef:test;bgcolor:transparent;margin-right:0pt\"/>\n"
                + "</styles>\n"
                + "<section footer=\"114\" header=\"73\" xid=\"914\" props=\"page-margin-right:2.54cm;ef:element..基本信息;page-margin-header:0.00cm;page-margin-left:2.54cm;page-margin-evendiff:0;page-margin-top:6.80cm;page-margin-footer:1.00cm;page-margin-bottom:2.54cm;et:9\">\n"
                + "<p style=\"Normal\" xid=\"39\"><c>    </c><c props=\"et:9;font-weight:bold;ef:element..主诉\">主  诉:</c><c props=\"er:RA_主诉.RB_主诉+1\">发现右侧颈部瘘口11年</c><c>。</c></p>\n"
                + "</section>\n"
                + "</uwword>";

        // 正则表达式匹配主诉内容
        Pattern pattern = Pattern.compile("<c[^>]*>主\\s*诉:</c><c[^>]*>(.*?)</c>");
        Matcher matcher = pattern.matcher(document);

        if (matcher.find()) {
            String complaint = matcher.group(1);
            System.out.println("主诉内容: " + complaint);
        } else {
            System.out.println("未找到主诉内容");
        }
    }
}
