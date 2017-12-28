<%@ Page Title="Pagina Proyecto" Language="C#" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeBehind="VerProyecto.aspx.cs" Inherits="Proyecto.VerProyecto" %>
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
        <li><a href="Proyect.aspx">Proyectos</a></li>
      <li><a href="default.aspx">Cerrar Sesion</a></li>
    </ul>
  </div>
</nav>
        <h2><%: Title %></h2>
         <div class="row">
          <div class="col-sm-4">
              <p>
        <asp:Label ID="salida" runat="server" Text=""></asp:Label>
            </p>

          </div>
          <div class="col-sm-8">
              <div class="form-group">
                  <label for="comment">Escribir nueva tarea</label>
                  <asp:TextBox runat="server" class="form-control" rows="5" cols="20" id="publicacion"></asp:TextBox>
                   <asp:Button ID="enviar" runat="server" Text="Agregar" OnClick="enviar_Click" />
                </div>
              <p>
        <asp:Label ID="atareado" runat="server" Text=""></asp:Label>
            </p>

          </div>
    </div> 
    </div>
</asp:Content>
