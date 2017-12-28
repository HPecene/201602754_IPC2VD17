using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Proyecto
{
    public partial class Amigos : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            WebServiceUser.ServicioUsuarios ami = new WebServiceUser.ServicioUsuarios();
            String id = Session["idUsuarioActual"].ToString();
            WebServiceUser.user[] listaAmigos = ami.BuscarAmigo(int.Parse(id));
            String tabla = "<table class=\"table table-bordered\" > " +
                "<tr><th>Amigos</th><th>Correo</th><th>Visitar</th></tr>";
            try
            {
                foreach (WebServiceUser.user amigo in listaAmigos)
                {
                    tabla = tabla + "<tr><td>" + amigo.nickname + "</td><td>" + amigo.email + "</td>" +
                        "<td><a href=Visita.aspx?u="+amigo.id+">Click here </a></td></tr>";
                }
            }
            catch (Exception)
            {

            }


            salida.Text = tabla +  "  </table>";
        }

        protected void enviar_amigo(object sender, EventArgs e)
        {
            WebServiceUser.ServicioUsuarios usa = new WebServiceUser.ServicioUsuarios();
            String id = Session["idUsuarioActual"].ToString();

            usa.Amigo(nuevaAmistad.Text,int.Parse(id));

            Page_Load(null, EventArgs.Empty);
        }

        protected void verPerfil(object sender, EventArgs e)
        {
            Console.WriteLine("FUK ME HARDER");
        }
    }
}