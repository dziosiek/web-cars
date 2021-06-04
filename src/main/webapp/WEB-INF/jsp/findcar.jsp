<html>
<head><title>First JSP</title></head>
<body>

  <form action = "${request.contextPath}/carlist" method="post">
                Marka Samochodu<input type = "text" name = "carBrand"><br><br>
                <input type = "submit" value = "Submit">
  </form>

</body>
</html>