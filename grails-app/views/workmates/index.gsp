<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="layout" content="main"/>
    <title>Create Registration</title>
</head>
<body>

<h1>Successfully send invitation to ${workmates.size()} ThoughtWorker :</h1>
<ul style="list-style:none">
    <g:each in="${workmates}">
        <li style="margin:2px">${it}</li>
    </g:each>
</ul>


</body>
</html>

