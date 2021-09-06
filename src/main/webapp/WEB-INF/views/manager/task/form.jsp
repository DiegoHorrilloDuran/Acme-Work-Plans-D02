<%--
- form.jsp
-
- Copyright (C) 2012-2021 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>

<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>



<jstl:if test="${command=='create' }">
	<acme:form>
	<acme:form-textbox code="authenticated.manager.task.create.label.title" path="title"/>
	<acme:form-textbox code="authenticated.manager.task.create.label.start" path="start" placeholder="yyyy/mm/dd hh:mm [en], dd/mm/AAAA hh:mm [es]"/>
	<acme:form-textbox code="authenticated.manager.task.create.label.end" path="end" placeholder="yyyy/mm/dd hh:mm [en], dd/mm/AAAA hh:mm [es]"/>
	<acme:form-textbox code="authenticated.manager.task.create.label.workload" path="workload"/>
	<acme:form-textarea code="authenticated.manager.task.create.label.description" path="description"/>
	<acme:form-textbox code="authenticated.manager.task.create.label.optionalLink" path="optionalLink"/>
	<acme:form-checkbox code="authenticated.manager.task.create.label.privacy" path="privacy"/>
			
	<acme:form-submit test="${command == 'create'}" code="authenticated.manager.task.form.button.create" action="/manager/task/create"/>
	<acme:form-return code="authenticated.manager.task.form.button.return"/>
	</acme:form>
</jstl:if>
<jstl:if test="${command=='show' or command=='update'}">
	<acme:form>
	<acme:form-textbox code="authenticated.manager.task.create.label.title" path="title"/>
	<acme:form-textbox code="authenticated.manager.task.create.label.start" path="start"/>
	<acme:form-textbox code="authenticated.manager.task.create.label.end" path="end"/>
	<acme:form-textbox code="authenticated.manager.task.create.label.workload" path="workload"/>
	<acme:form-textarea code="authenticated.manager.task.create.label.description" path="description"/>
	<acme:form-textbox code="authenticated.manager.task.create.label.optionalLink" path="optionalLink"/>
	<acme:form-checkbox code="authenticated.manager.task.create.label.privacy" path="privacy"/>
	
    	<acme:form-submit code="authenticated.manager.task.list.button.update" action="/manager/task/update"/>
     	<acme:form-submit code="authenticated.manager.task.list.button.delete" action="/manager/task/delete"/>
		<acme:form-return code="authenticated.manager.task.form.button.return"/>
	</acme:form>
</jstl:if>



