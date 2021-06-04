<html>
<head><title>CarList</title></head>
<body>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <h5>Lista pojazdów wg marki: <%= request.getParameter("carBrand") %></h5>
    <table>
      <c:forEach items="${cars}" var="car">
        <tr>
          <td><c:out value="${car}" /></td>
        </tr>
      </c:forEach>
    </table>




</body>
</html>