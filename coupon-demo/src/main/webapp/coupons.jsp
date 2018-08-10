<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>List of Coupons</title>
</head>
<body>

<a href="input"/>">Add New Coupons</a>
<table border="1">
    <tr>
        <th><s:text name="Id"/></th>
        <th><s:text name="Name"/></th>
        <th><s:text name="PromoCode"/></th>
        <th><s:text name="Category"/></th>
        <th>&nbsp;</th>
    </tr>

    <s:iterator value="coupons">
        <tr>
            <td><s:property value="id"/></td>
            <td><s:property value="name"/></td>
            <td><s:property value="promocode"/></td>
            <td><s:property value="category"/></td>
            <td>
                <s:url action="edit" id="url">
                    <s:param name="coupon.id" value="id"/>
                </s:url>
                <a href="<s:property value="#url"/>">Edit</a>
                &nbsp;&nbsp;&nbsp;
                <s:url action="delete" id="url">
                    <s:param name="coupon.id" value="id"/>
                </s:url>
                <a href="<s:property value="#url"/>">Delete</a>
            </td>
        </tr>
    </s:iterator>
    </table>
</body>
</html>