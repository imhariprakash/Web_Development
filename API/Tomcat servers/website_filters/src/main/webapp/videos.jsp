<%@ page contentType="text/html; charset=UTF-8" %>

<%

    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
    response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
    response.setHeader("Expires", "0"); // Proxies.


    if(session.getAttribute("user") == null){
        response.sendRedirect("login_page.jsp");
    }
%>

<!DOCTYPE html>
<html>
<head>
    <style>
        .btn {
            background: #3498db;
            background-image: -webkit-linear-gradient(top, #3498db, #2980b9);
            background-image: -moz-linear-gradient(top, #3498db, #2980b9);
            background-image: -ms-linear-gradient(top, #3498db, #2980b9);
            background-image: -o-linear-gradient(top, #3498db, #2980b9);
            background-image: linear-gradient(to bottom, #3498db, #2980b9);
            -webkit-border-radius: 33;
            -moz-border-radius: 33;
            border-radius: 33px;
            font-family: Georgia;
            color: #050405;
            font-size: 20px;
            padding: 10px 20px 10px 20px;
            text-decoration: none;
          }

          .btn:hover {
            background: #3cb0fd;
            background-image: -webkit-linear-gradient(top, #3cb0fd, #3498db);
            background-image: -moz-linear-gradient(top, #3cb0fd, #3498db);
            background-image: -ms-linear-gradient(top, #3cb0fd, #3498db);
            background-image: -o-linear-gradient(top, #3cb0fd, #3498db);
            background-image: linear-gradient(to bottom, #3cb0fd, #3498db);
            text-decoration: none;
          }
    </style>
    <body>
        <p style="display: block; marginleft:auto; marginright:auto;width:40%">
            Video courtesy of <br><br><br>
            <iframe frameborder="0" scrolling="no" marginheight="0"
                marginwidth="0" width="788.54" height="443" type="text/html"
                src="https://www.youtube.com/embed/GZvSYJDk-us?autoplay=0&fs=0&iv_load_policy=3&showinfo=0&rel=0&cc_load_policy=0&start=0&end=0&origin=http://youtubeembedcode.com"><div><small><a
                            href="https://youtubeembedcode.com/nl/">youtubeembedcode
                            nl</a></small></div><div><small><a
                            href="https://nyacasinonutansvensklicens.nu/">https://nyacasinonutansvensklicens.nu/</a></small></div><div><small><a
                            href="https://youtubeembedcode.com/nl/">youtubeembedcode
                            nl</a></small></div><div><small><a
                            href="https://spelbolagutanspelpaus.com/">spelbolagutanspelpaus.com</a></small></div><div><small><a
                            href="https://youtubeembedcode.com/de/">youtubeembedcode.com/de/</a></small></div><div><small><a
                            href="https://nyacasinonutansvensklicens.nu/">nya
                            casinon utan svensk licens</a></small></div><div><small><a
                            href="https://youtubeembedcode.com/de/">youtubeembedcode
                            de</a></small></div><div><small><a
                            href="https://spelbolagutanspelpaus.com/">spelbolag
                            utan spelpaus</a></small></div></iframe>
        </p>

        <div">

            <form action="logout.jsp" method="post">
                <input type="submit" value="Logout" class="btn">
            </form>

            <br>

            <form action="welcome.jsp">
                <input type="submit" value="Home" class="btn">
            </form>
        </div>
    </body>
</html>