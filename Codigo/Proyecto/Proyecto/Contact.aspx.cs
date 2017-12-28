using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Proyecto
{
    public partial class Contact : Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

            WebServiceHabil.ServicioHabilidades hab = new WebServiceHabil.ServicioHabilidades();
            String id = Session["idUsuarioActual"].ToString();
            WebServiceHabil.habilidad[] listaHab = hab.BuscarHabilidades(int.Parse(id));
            int karmaT = 0;
            String tabla = "<table class=\"table table-bordered\" > " +
                "<tr><th>Habilidad</th><th>Karma</th></tr>";
            try {
                foreach (WebServiceHabil.habilidad hability in listaHab)
                {
                    tabla = tabla + "<tr><td>" + hability.habilidad1 + "</td>       <td>" + hability.karma + "</td></tr>";
                    karmaT = karmaT + hability.karma;
                }
            }
            catch (Exception) {

            }
            

            salida.Text = tabla + "<tr><th>TOTAL</th><th>"+karmaT+"</th></tr>" + "  </table>";

            WebServicePost.ServicioPosts pos = new WebServicePost.ServicioPosts();
            id = Session["idUsuarioActual"].ToString();
            WebServicePost.post[] listaPos = pos.BuscarPost(int.Parse(id));

            tabla = "<table class=\"table table-bordered\" > " +
                "<tr><th>POSTS</th></tr>";
            try {
                foreach (WebServicePost.post poste in listaPos.Reverse())
                {
                    tabla = tabla + "<tr><td>" + poste.post1 + "</td></tr>";
                }
            }
            catch (ArgumentNullException) {

            }
           

            posteado.Text = tabla + "  </table>";
            
        }

        protected void enviar_Click(object sender, EventArgs e)
        {
            WebServicePost.ServicioPosts postear = new WebServicePost.ServicioPosts();
            String id = Session["idUsuarioActual"].ToString();

            postear.AgrearPost(publicacion.Text, int.Parse(id));

            Page_Load(null, EventArgs.Empty);
        }

        protected void enviar_habilidad(object sender, EventArgs e)
        {
            WebServiceHabil.ServicioHabilidades hab = new WebServiceHabil.ServicioHabilidades();
            String id = Session["idUsuarioActual"].ToString();

            hab.AgrearHabilidad(nuevaHabilidad.Text, 0, int.Parse(id));

            Page_Load(null, EventArgs.Empty);
        }
    }
}