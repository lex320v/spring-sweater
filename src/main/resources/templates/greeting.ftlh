<#import "parts/common.ftlh" as c>

<@c.page>
    <div>
        <form method="post" action="/create">
            <input type="text" name="name" placeholder="username"/>
            <input type="text" name="email" placeholder="email">
            <button type="submit">Add</button>
        </form>
    </div>

    <div>Users list</div>
    <form method="get" action="/search">
        <input type="text" name="filter">
        <button type="submit">Find</button>
    </form>
    <hr>
<#--    <#list users as user>-->
<#--        <span>${user.getId()}</span>-->
<#--        <span>${user.get}</span>-->
<#--        <span>${user.getEmail()}</span>-->
<#--        <hr>-->
<#--    <#else>-->
<#--        <p>List is empty</p>-->
<#--    </#list>-->
</@c.page>
