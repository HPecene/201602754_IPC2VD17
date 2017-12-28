<%@ Page Title="Timeline" Language="C#" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeBehind="Timeline.aspx.cs" Inherits="Proyecto.Timeline" %>
<asp:Content ID="Content1" ContentPlaceHolderID="MainContent" runat="server">
    <div class="container">
        <nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">WARCRAFT</a>
    </div>
    <ul class="nav navbar-nav">
      <li><a href="Contact.aspx">Perfil</a></li>
        <li class="active"><a href="Timeline.aspx">Timeline</a></li>
        <li><a href="Amigos.aspx">Amigos</a></li>
         <li><a href="Asociacion.aspx">Asociaciones</a></li>
        <li><a href="Proyect.aspx">Proyectos</a></li>
      <li><a href="default.aspx">Cerrar Sesion</a></li>
    </ul>
  </div>
</nav>
        <h2><%: Title %></h2>
         <div class="row">
          <div class="col-sm-12">
              <p>
        <asp:Label ID="salida" runat="server" Text=""></asp:Label>
            </p>

          </div>
             
    </div> 
    </div>
</asp:Content>
