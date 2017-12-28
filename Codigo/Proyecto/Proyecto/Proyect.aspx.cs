using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Proyecto
{
    public partial class Proyect : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            WebServicePro.ServicioProyectos pro = new WebServicePro.ServicioProyectos();
            String id = Session["idUsuarioActual"].ToString();
            WebServicePro.proyecto[] listaPro = pro.BuscarProyectos(int.Parse(id));
            String tabla = "<table class=\"table table-bordered\" > " +
                "<tr><th>Proyecto</th><th>Ver</th></tr>";
            try
            {
                foreach (WebServicePro.proyecto proye in listaPro)
                {
                    tabla = tabla + "<tr><td>" + proye.proyecto1 + "</td>" +
                        "<td><a href=VerProyecto.aspx?u=" + proye.id + ">Click here </a></td></tr>";
                }
            }
            catch (Exception)
            {

            }


            salida.Text = tabla + "  </table>";
        }

        protected void enviar_proyecto(object sender, EventArgs e)
        {
            WebServicePro.ServicioProyectos usa = new WebServicePro.ServicioProyectos();
            String id = Session["idUsuarioActual"].ToString();

            usa.AgregarProyecto(nuevoProyecto.Text, int.Parse(id));

            Page_Load(null, EventArgs.Empty);
        }
    }
}