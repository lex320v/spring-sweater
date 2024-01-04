<#import "parts/common.ftlh" as c>

<@c.page>
    <h3>upload</h3>
    <form method="post" action="/upload-file" enctype="multipart/form-data">
        <input type="text" name="filename">
        <input type="file" name="file">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <input type="submit">
    </form>
</@c.page>