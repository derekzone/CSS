<!DOCTYPE html>
<html>
<#include "./include/head.ftl">
<body>
<#include "./include/support.ftl">
<#include "./include/header.ftl">
<#--<#assign listType = 0>-->

</div>
<div class="g-doc">
    <div class="m-tab m-tab-fw m-tab-simple f-cb">
        <div class="tab">
            <ul>
                <li class="z-sel"><a href="/">所有内容</a></li>
                <#if user??>
                    <li><a href="/?type=1">未购买的内容</a></li>
                </#if>
            </ul>
        </div>
    </div>
    <div class="n-plist">
        <ul class="f-cb" id="plist">
            <#if user??>
                 <#list contentVOList as c>
                    <li id="p-${c.id}">
                        <a href="/show?id=${c.id}" class="link">
                            <div class="img"><img src="${c.image}" alt="${c.title}"></div>
                            <h3>${c.title}</h3>
                            <div class="price"><span class="v-unit">¥</span><span class="v-value">${c.price}</span>
                            </div>
                            <#if c.isBuy() == true>
                                <span class="had"><b>已购买</b></span>
                            </#if>
                        </a>
                    </li>
                 </#list>
            </#if>
        </ul>
    </div>
</div>



<#include "./include/footer.ftl">
<script type="text/javascript" src="/static/js/global.js"></script>
<script type="text/javascript" src="/static/js/pageIndex.js"></script>
</body>
</html>