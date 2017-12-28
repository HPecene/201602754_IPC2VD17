using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Proyecto
{
    public partial class VerProyecto : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            WebServiceTarea.ServicioTareas pos = new WebServiceTarea.ServicioTareas();
            String id = Request.QueryString["u"];
            WebServiceTarea.tarea[] listaPos = pos.BuscarTareas(int.Parse(id));

            String tabla = "<table class=\"table table-bordered\" > " +
                "<tr><th>TAREAS</th></tr>";
            try
            {
                foreach (WebServiceTarea.tarea poste in listaPos.Reverse())
                {
                    tabla = tabla + "<tr><td>" + poste.tarea1 + "</td></tr>";
                }
            }
            catch (ArgumentNullException)
            {

            }


            atareado.Text = tabla + "  </table>";
        }

        protected void enviar_Click(object sender, EventArgs e)
        {
            WebServiceTarea.ServicioTareas tarear = new WebServiceTarea.ServicioTareas();
            String id = Request.QueryString["u"];

            tarear.AgregarTarea(publicacion.Text, int.Parse(id));

            Page_Load(null, EventArgs.Empty);
        }
    }
}