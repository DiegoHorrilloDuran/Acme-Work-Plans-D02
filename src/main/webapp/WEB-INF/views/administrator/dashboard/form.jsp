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

<acme:form readonly="true">
	<acme:form-textbox code="administrator.dashboard.form.label.numberOfPrivateTasks" path="numberOfPrivateTasks" />
	<acme:form-textbox code="administrator.dashboard.form.label.numberOfPublicTasks" path="numberOfPublicTasks"/>
	<acme:form-textbox code="administrator.dashboard.form.label.numberOfFinishedTasks" path="numberOfFinishedTasks"/>
	<acme:form-textbox code="administrator.dashboard.form.label.numberOfUnfinishedTasks" path="numberOfUnfinishedTasks"/>
	<acme:form-textbox code="administrator.dashboard.form.label.maxTaskExecutionPeriod" path="maxTaskExecutionPeriod"/>
	<acme:form-textbox code="administrator.dashboard.form.label.minTaskExecutionPeriod" path="minTaskExecutionPeriod"/>
	<acme:form-textbox code="administrator.dashboard.form.label.avgTaskExecutionPeriods" path="avgTaskExecutionPeriods"/>
	<acme:form-textbox code="administrator.dashboard.form.label.stdDevTaskExecutionPeriods" path="stdDevTaskExecutionPeriods"/>
	<acme:form-textbox code="administrator.dashboard.form.label.maxTaskWorkload" path="maxTaskWorkload"/>
	<acme:form-textbox code="administrator.dashboard.form.label.minTaskWorkload" path="minTaskWorkload"/>
	<acme:form-textbox code="administrator.dashboard.form.label.avgTaskWorkloads" path="avgTaskWorkloads"/>
	<acme:form-textbox code="administrator.dashboard.form.label.stdDevTaskWorkloads" path="stdDevTaskWorkloads"/>
		
  	<acme:form-return code="administrator.dashboard.form.button.return"/>
</acme:form>
