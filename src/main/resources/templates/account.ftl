<!DOCTYPE html>
<html>
<#include "./include/head.ftl">
<body>
<#include "./include/support.ftl">
<#include "./include/header.ftl">
</div>
<div class="g-doc">
    <div class="m-tab m-tab-fw m-tab-simple f-cb">
        <h2>已购买的内容</h2>
    </div>
    <table class="m-table m-table-row n-table g-b3">
        <colgroup>
            <col class="img"/>
            <col/>
            <col class="time"/>
            <col/>
            <col class="num"/>
            <col/>
            <col class="price"/>
            <col/>
        </colgroup>
        <thead>
        <tr>
            <th>内容图片</th>
            <th>内容名称</th>
            <th>购买时间</th>
            <th>购买数量</th>
            <th>购买价格</th>
        </tr>
        </thead>
        <tbody>
        <#list contentVOS as c>
        <tr>
            <td><a href="/show?id=${c.id}"><img src="${c.image}" alt=""></a></td>
            <td><h4><a href="/show?id=${c.id}">${c.title}</a></h4></td>
            <td><span class="v-time">${c.buyTime?datetime}</span></td>
            <td><span class="v-num">${c.num}</span></td>
            <td><span class="v-unit">¥</span><span class="value">${c.buyPrice*c.num}</span></td>
        </tr>
        </#list>
        </tbody>
        <tfoot>
        <tr>
            <td colspan="4">
                <div class="total">总计：</div>
            </td>
            <td><span class="v-unit">¥</span><span class="value">${total}</span></td>
        </tr>
        </tfoot>
    </table>

</div>
<#include "./include/footer.ftl">
</body>
</html>