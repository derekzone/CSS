<!DOCTYPE html>
<html>
<#include "./include/head.ftl">
<body>
<#include "./include/support.ftl">
<#include "./include/header.ftl">
</div>
<div class="g-doc">
    <#if !content??>
        <div class="n-result">
            <h3>内容不存在！</h3>
        </div>
    <#else>
    <div class="n-show f-cb" id="showContent">
        <div class="img"><img src="${content.image}" alt=""></div>
        <div class="cnt">
            <h2>${content.title}</h2>
            <p class="summary">${content.summary}</p>
            <div class="price">
                <span class="v-unit">¥</span><span class="v-value">${content.price}</span>
            </div>
            <div class="num">购买数量：<span id="plusNum" class="lessNum"><a>-</a></span><span class="totalNum"
                                                                                          id="allNum">0</span><span
                    id="addNum" class="moreNum"><a>+</a></span></div>
            <div class="oprt f-cb">
            </div>
        </div>
    </div>
    <div class="m-tab m-tab-fw m-tab-simple f-cb">
        <h2>详细信息</h2>
    </div>
    <div class="n-detail">
        ${content.detail}
    </div>
    </#if>
</div>
<#include "./include/footer.ftl">
<script type="text/javascript" src="/static/js/global.js"></script>
<script type="text/javascript" src="/static/js/pageShow.js"></script>
</body>
</html>