using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Proyecto
{
    public partial class Timeline : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            WebServicePost.ServicioPosts pos = new WebServicePost.ServicioPosts();
            String id = Session["idUsuarioActual"].ToString();
            WebServicePost.post[] listaPos = pos.ConseguirTimeline(int.Parse(id));

            String tabla = "<table class=\"table table-bordered\" > " +
                "<tr><th>USUARIO</th><th>POST</th></tr>";
            try
            {
                foreach (WebServicePost.post poste in listaPos.Reverse())
                {
                    tabla = tabla + "<tr><td>" + poste.creador + "</td><td>" + poste.post1 + "</td></tr>";
                }
            }
            catch (ArgumentNullException)
            {

            }


            salida.Text = tabla + "  </table>";
        }
    }
}