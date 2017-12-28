using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Proyecto
{
    public partial class Asociacion : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            WebServiceAsoci.ServicioAsociaciones ami = new WebServiceAsoci.ServicioAsociaciones();
            String id = Session["idUsuarioActual"].ToString();
            WebServiceAsoci.asociacion[] listaAsocia = ami.BuscarAsociaciones(int.Parse(id));
            String tabla = "<table class=\"table table-bordered\" > " +
                "<tr><th>Asociacion</th></tr>";
            try
            {
                foreach (WebServiceAsoci.asociacion asociacion in listaAsocia)
                {
                    tabla = tabla + "<tr><td>" + asociacion.asociacion1 + "</td></tr>";
                }
            }
            catch (Exception)
            {

            }


            salida.Text = tabla + "  </table>";
        }

        protected void enviar_asociacion(object sender, EventArgs e)
        {
            WebServiceAsoci.ServicioAsociaciones usa = new WebServiceAsoci.ServicioAsociaciones();
            String id = Session["idUsuarioActual"].ToString();

            usa.AgregarAsociacion(nuevaAsociacion.Text, int.Parse(id));

            Page_Load(null, EventArgs.Empty);
        }
    }
}