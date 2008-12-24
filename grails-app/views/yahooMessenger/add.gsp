<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="layout" content="main"/>
    <title>Create Registration</title>
</head>
<body>

<h1>Successfully send invitation to ${results.allSucceed().size()} ThoughtWorker :</h1>
<ul style="list-style:none">
    <g:each in="${results.allSucceed()}">
        <li style="margin:2px">${it.getMessage()}</li>
    </g:each>
</ul>

<h1 style="margin:10px;">Failed to invite ${results.allFailed().size()} ThoughtWorkers :</h1>

<ul style="list-style:none">
    <g:each in="${results.allFailed()}">
        <li style="margin:2px">${it.getMessage()}</li>
    </g:each>
</ul>

</body>
</html>

