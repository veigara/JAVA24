<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class=" sidebar" role="navigation">
            <div class="navbar-collapse">
				<nav class="cbp-spmenu cbp-spmenu-vertical cbp-spmenu-left" id="cbp-spmenu-s1">
					<ul class="nav" id="side-menu">
					    <c:forEach items="${owerMenu }" var="one">
					       <li class="active">
					           <a href="javascript:void(0);" dataUrl="${one.menuUrl }">
					               <i class="fa fa-cogs nav_icon"></i>${one.menuName } 
					                     <span class="fa arrow"></span>
					           </a>
					           
					           <ul class="nav nav-second-level collapse in" aria-expanded="true">
					               <c:forEach items="${one.childMenu }" var="two">
					                   <li>
						                    <a href="javascript:void(0);" dataUrl="${two.menuUrl }">
									               <i class="fa fa-cogs nav_icon"></i>${two.menuName } 
									                     <span class="fa arrow"></span>
									         </a>
										       <ul class="nav nav-second-level collapse in" aria-expanded="true">
											      <c:forEach items="${two.childMenu }" var="three">
											          <li>
											                <a href="javascript:void(0);" dataUrl="${three.menuUrl }">
													               <i class="fa fa-cogs nav_icon"></i>${three.menuName } 
													                     <span class="fa arrow"></span>
													         </a>
											          </li>  
											      </c:forEach>  
										      </ul>   
					                   </li>
					               </c:forEach>
					           </ul>
					       </li>
					    </c:forEach>
					</ul>
					<!-- //sidebar-collapse -->
					
				</nav>
			</div>
		</div>