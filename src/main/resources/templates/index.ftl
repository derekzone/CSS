<!DOCTYPE html>
<html>
<#include "./include/head.ftl">
<body>
<#include "./include/support.ftl">
<#include "./include/header.ftl">
</div>
<div class="g-doc">
    <div class="m-tab m-tab-fw m-tab-simple f-cb">
        <div class="tab">
            <ul>
                <li <#if type?? && type != 1>class="z-sel"</#if> ><a href="/">所有内容</a></li>
                <#if user?? && user.type == 1>
                    <li <#if type?? && type == 1>class="z-sel"</#if> ><a href="/?type=1">未购买的内容</a></li>
                </#if>
            </ul>
        </div>
    </div>
    <div class="n-plist">
        <ul class="f-cb" id="plist">
            <#if user??>
                <#assign list = contentVOList>
            <#else>
                <#assign list = contentList>
            </#if>
            <#list list as c>
                <li id="p-${c.id}">
                    <a href="/show?id=${c.id}" class="link">
                        <div class="img"><img src="${c.image}" alt="${c.title}"></div>
                        <h3>${c.title}</h3>
                        <div class="price"><span class="v-unit">¥</span><span class="v-value">${c.price}</span>
                        </div>
                <#if user??>
                    <#if c.isBuy() == true>
                        <#if user.type ==  1>
                                <span class="had"><b>已购买</b></span>
                        <#else >
                                <span class="had"><b>已售出</b></span>
                        </#if>
                    </#if>
                </#if>
                    </a>
                    <#if user?? && user.type == 2 && c.isBuy() == false>
                         <span class="u-btn u-btn-normal u-btn-xs del" data-del="${c.id}">删除</span>
                    </#if>
                </li>
            </#list>
        </ul>
    </div>
</div>
<#include "./include/footer.ftl">
<script type="text/javascript" src="/static/js/global.js"></script>
<script type="text/javascript" src="/static/js/pageIndex.js"></script>
</body>
</html>