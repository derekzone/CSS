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
        <#if user??>
            <#assign c = contentVO>
        <#else >
            <#assign c = content>
        </#if>
        <div class="img"><img src="${c.image}" alt=""></div>
        <div class="cnt">
            <h2>${c.title}</h2>
            <p class="summary">${c.summary}</p>
            <div class="price">
                <span class="v-unit">¥</span><span class="v-value">${c.price}</span>
            </div>
            <div class="num">购买数量：<span id="plusNum" class="lessNum"><a>-</a></span><span class="totalNum"
                                                                                          id="allNum">0</span><span
                    id="addNum" class="moreNum"><a>+</a></span></div>
            <div class="oprt f-cb">
                <#if user??>
                    <#if user.type == 1>
                        <#if c.isBuy()>
                    <span class="u-btn u-btn-primary z-dis">已购买</span>
                    <span class="buyprice">当时购买价格：¥${c.buyPrice}</span>
                        <#else >
                    <button class="u-btn u-btn-primary" id="add" data-id="${c.id}" data-title="${c.title}"
                            data-price="${c.price}">
                        加入购物车
                    </button>
                        </#if>
                    <#else >
                     <a href="/edit?id=${c.id}" class="u-btn u-btn-primary">编 辑</a>
                    </#if>
                </#if>
            </div>
        </div>
    </div>
    <div class="m-tab m-tab-fw m-tab-simple f-cb">
        <h2>详细信息</h2>
    </div>
    <div class="n-detail">
        ${c.detail}
    </div>
    </#if>
</div>
<#include "./include/footer.ftl">
<script type="text/javascript" src="/static/js/global.js"></script>
<script type="text/javascript" src="/static/js/pageShow.js"></script>
</body>
</html>