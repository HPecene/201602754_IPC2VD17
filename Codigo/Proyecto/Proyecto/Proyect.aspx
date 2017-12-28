<%@ Page Title="Proyectos" Language="C#" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeBehind="Proyect.aspx.cs" Inherits="Proyecto.Proyect" %>
<asp:Content ID="Content1" ContentPlaceHolderID="MainContent" runat="server">
    <div class="container">
        <nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">WARCRAFT</a>
    </div>
    <ul class="nav navbar-nav">
      <li><a href="Contact.aspx">Perfil</a></li>
        <li><a href="Timeline.aspx">Timeline</a></li>
        <li><a href="Amigos.aspx">Amigos</a></li>
        <li><a href="Asociacion.aspx">Asociaciones</a></li>
        <li class="active"><a href="Proyect.aspx">Proyectos</a></li>
      <li><a href="default.aspx">Cerrar Sesion</a></li>
    </ul>
  </div>
</nav>
        <h2><%: Title %></h2>
         <div class="row">
          <div class="col-sm-6">
               <asp:TextBox runat="server" class="form-control" rows="5" cols="20" id="nuevoProyecto"></asp:TextBox>
                   
          </div>
          <div class="col-sm-6">
              <asp:Button ID="AgregarProyecto" runat="server" Text="Agregar" OnClick="enviar_proyecto" />
          </div>
        </div> 
    </div>
    <div class="row">
          <div class="col-sm-12">
              <h2>Proyectos</h2>

               <asp:Label ID="salida" runat="server" Text=""></asp:Label>
                   
          </div>
    </div>
</asp:Content>
