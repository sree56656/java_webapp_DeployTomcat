<!DOCTYPE html>
<html>
<head>
    <title>Simple Java Web App</title>
</head>
<body>
    <h1>Welcome to My Java Web App</h1>
    <form action="hello" method="post">
        <label for="name">Enter your name:</label>
        <input type="text" id="name" name="name" required>
        <button type="submit">Submit</button>
    </form>

    <p style="color: green;">
        <% if (request.getAttribute("greeting") != null) { %>
            <%= request.getAttribute("greeting") %>
        <% } %>
    </p>
</body>
</html>
