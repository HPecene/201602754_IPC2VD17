using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Proyecto
{
    public partial class _Default : Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void enviar_Click(object sender, EventArgs e)
        {
            WebServiceUser.ServicioUsuarios wu = new WebServiceUser.ServicioUsuarios();

            if (wu.Login(txt_user.Text, txt_clave.Text) != 0)
            {
                this.Session["idUsuarioActual"] = wu.Login(txt_user.Text, txt_clave.Text);
                Response.Redirect("Contact.aspx");

            }
            else {

                ClientScript.RegisterStartupScript(this.GetType(), "myalert", "alert('DATOS ERRONEOS');", true);
            }
        }

        protected void registrarUser(object sender, EventArgs e)
        {
            WebServiceUser.ServicioUsuarios wu = new WebServiceUser.ServicioUsuarios();

            wu.CrearUsuario(TextBox1.Text,TextBox2.Text,TextBox3.Text);
        }
    }
}