<%@ page language="java" import="com.jielan.model.query.PageQuery" pageEncoding="UTF-8"%>
<div class="pagelist">
<%
        PageQuery query=(PageQuery)request.getAttribute("query");
    %>
    <input type="hidden" id="pageindex" name="pageindex" value="1" />
    <ul>
        <li><input class="but1"  type="button" value="< 上一页" onclick="lastpage()" /></li>
        <li>
            <% if(query.getPagecount()<8){
                for(int i=1;i<=query.getPagecount();i++){
                    if(query.getPageindex()==i){
            %>
            <a href="#" style="background:#09F" onclick="selected(<%=i %>)"><%=i %></a>
            <%}else{ %>
            <a href="#" onclick="selected(<%=i %>)"><%=i %></a>
            <%
                    }
                }
            }else{
                if(query.getPageindex()<5){
                    for(int i=1;i<=8;i++){
                        if(query.getPageindex()==i){
            %>
            <a href="#" style="background:#09F" onclick="selected(<%=i %>)"><%=i %></a>
            <%}else{ %>
            <a href="#" onclick="selected(<%=i %>)"><%=i %></a>
            <%}
            }
            }else{
                if(query.getPagecount()-query.getPageindex()<8){
                    for(int i=query.getPagecount()-7;i<=query.getPagecount();i++){
                        if(query.getPageindex()==i){
            %>
            <a href="#" style="background:#09F" onclick="selected(<%=i %>)"><%=i %></a>
            <%}else{ %>
            <a href="#" onclick="selected(<%=i %>)"><%=i %></a>
            <%
                    }
                }
            }else{
                for(int i=query.getPageindex()-3;i<=query.getPageindex()+4;i++){
                    if(query.getPageindex()==i){
            %>
            <a href="#" style="background:#09F" onclick="selected(<%=i %>)"><%=i %></a>
            <%}else{ %>
            <a href="#" onclick="selected(<%=i %>)"><%=i %></a>
            <%
                                }
                            }
                        }
                    }
                }
            %>
        </li>
        <li><input class="but1" id="nextpage" type="button" value="下一页 >" onclick="nextpages()"/></li>
        <li>共 <%=query.getPagecount() %>页</li>
        <li>共 <%=query.getRecordcount() %>条记录</li>
        <li>转到第 <input class="input1" id="pagNo" name="" type="text" /> 页</li>
        <li><input onclick="tiaozhuan()" class="but1" name="" type="button" value="确定" /></li>
    </ul>
</div>

<script language="javascript">
    var pag=<c:out value="${query.pagecount}"/>;
    var index=<c:out value="${query.pageindex}"/>;
    /**
     * 页面输入跳转页面
     */
    function tiaozhuan(){
        var indexpage=$("#pagNo").val();
        if(indexpage>pag){
            $("#pagNo").focus();
            alert("输入页数大于总页数");
            $("#pagNo").val('');
        }else{
            if(indexpage.search("^[0-9]*[1-9][0-9]*$")!=0){
                $("#pagNo").focus();
                $("#pagNo").val('');
                alert("请输入数字");
            }else{
                $("#pageindex").val(indexpage);
                $("#beanForm").submit();
            }
        }
    }
    /**
     * 下一页
     */
    function nextpages(){
        if(pag==index){
            alert("已经是最后一页");
        }else{
            $("#pageindex").val(index+1);
            $("#beanForm").submit();
        }
    }
    /**
     * 上一页
     */
    function lastpage(){
        if(index==1){
            alert("已经是第一页");
        }else{
            $("#pageindex").val(index-1);
            $("#beanForm").submit();
        }
    }
    /**
     * 选择页面
     */
    function selected(page){
        $("#pageindex").val(page);
        $("#beanForm").submit();
    }
</script>
<style>
   .pagelist li{float:left}
</style>