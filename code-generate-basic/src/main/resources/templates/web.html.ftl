<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>${title}</title>
    </head>
    <body>
        <h1>${description}</h1>>
        <ul>
            <#list menuItem as item>
                <li><a href="${item}"/></li>
            </#list>
        </ul>
        <footer>
            <p>© ${currentYear} ${company} All Rights Reserved.</p>
        </footer>
    </body>
</html>