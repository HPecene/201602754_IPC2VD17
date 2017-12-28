<%@ Page Title="Iniciar Sesion" Language="C#" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeBehind="Default.aspx.cs" Inherits="Proyecto._Default" %>

<asp:Content ID="BodyContent" ContentPlaceHolderID="MainContent" runat="server">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <h2><%: Title %></h2>
    <p>Usuario:
        <asp:TextBox ID="txt_user" runat="server"></asp:TextBox>
    </p>
    <p>Clave:
        <asp:TextBox ID="txt_clave" runat="server"></asp:TextBox>
    </p>
    <p>
        <asp:Button ID="enviar" runat="server" Text="Entrar" OnClick="enviar_Click"/>
    </p>

    <h4>Registrar</h4>
    <p>Usuario:
        <asp:TextBox ID="TextBox1" runat="server"></asp:TextBox>
    </p>
    <p>Clave:
        <asp:TextBox ID="TextBox2" runat="server"></asp:TextBox>
    </p>
    <p>Email:
        <asp:TextBox ID="TextBox3" runat="server"></asp:TextBox>
    </p>
    <p>
        <asp:Button ID="Button1" runat="server" Text="Crear" OnClick="registrarUser"/>
    </p>


</asp:Content>
