<%--
/**
* Copyright (c) 2000-2010 Liferay, Inc. All rights reserved.
*
* This library is free software; you can redistribute it and/or modify it under
* the terms of the GNU Lesser General Public License as published by the Free
* Software Foundation; either version 2.1 of the License, or (at your option)
* any later version.
*
* This library is distributed in the hope that it will be useful, but WITHOUT
* ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
* FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
* details.
*/
--%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.netpage-germany.de/JSP/LiferayObjects" prefix="objects"%> 

<objects:loadObjects/>

<c:if test="!${hasElements}">
	<p><liferay-ui:message key="NoUserFound" /></p>
</c:if>

<c:if test="${hasElements}">
	<p><liferay-ui:message key="UserFound" /></p>

	<c:forEach var="entry" items="${users}">
		<p><liferay-ui:message key="Firma" />: <strong>${entry.key.mx}</strong></p>
		
		<ul>
			<c:forEach var="user" items="${entry.value}">
				<li>${user.lastName}, ${user.firstName}
					(${user.displayEmailAddress})</li>
			</c:forEach>
		</ul>
		
	</c:forEach>

</c:if>



