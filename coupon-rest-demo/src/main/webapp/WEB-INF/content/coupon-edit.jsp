<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
<head>
    <link href="<s:url value='/css/main.css'/>" rel="stylesheet" type="text/css"/>
</head>
<body>


<s:form action="save" method="post">
    <s:textfield name="coupon.id" value="%{coupon.id}" label="Id" size="40"/>
    <s:textfield name="coupon.name" value="%{coupon.name}" label="Name" size="40"/>
    <s:textfield name="coupon.promocode" value="%{coupon.promocode}" label="Promo Code" size="20"/>
    <s:textfield name="coupon.category" value="%{coupon.category}" label="Category" size="20"/>

    <s:hidden name="id" value="%{coupon.id}"/>
    <s:submit value="Submit"/>
    <s:submit value="Cancel" action="index"/>
</s:form>
</body>
</html>