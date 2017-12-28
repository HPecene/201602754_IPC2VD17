﻿//------------------------------------------------------------------------------
// <auto-generated>
//     Este código fue generado por una herramienta.
//     Versión de runtime:4.0.30319.42000
//
//     Los cambios en este archivo podrían causar un comportamiento incorrecto y se perderán si
//     se vuelve a generar el código.
// </auto-generated>
//------------------------------------------------------------------------------

// 
// Microsoft.VSDesigner generó automáticamente este código fuente, versión=4.0.30319.42000.
// 
#pragma warning disable 1591

namespace Proyecto.WebServiceHabil {
    using System;
    using System.Web.Services;
    using System.Diagnostics;
    using System.Web.Services.Protocols;
    using System.Xml.Serialization;
    using System.ComponentModel;
    
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Web.Services", "4.7.2556.0")]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.ComponentModel.DesignerCategoryAttribute("code")]
    [System.Web.Services.WebServiceBindingAttribute(Name="ServicioHabilidadesPortBinding", Namespace="http://servicios/")]
    public partial class ServicioHabilidades : System.Web.Services.Protocols.SoapHttpClientProtocol {
        
        private System.Threading.SendOrPostCallback BuscarHabilidadesOperationCompleted;
        
        private System.Threading.SendOrPostCallback AgrearHabilidadOperationCompleted;
        
        private bool useDefaultCredentialsSetExplicitly;
        
        /// <remarks/>
        public ServicioHabilidades() {
            this.Url = global::Proyecto.Properties.Settings.Default.Proyecto_WebServiceHabil_ServicioHabilidades;
            if ((this.IsLocalFileSystemWebService(this.Url) == true)) {
                this.UseDefaultCredentials = true;
                this.useDefaultCredentialsSetExplicitly = false;
            }
            else {
                this.useDefaultCredentialsSetExplicitly = true;
            }
        }
        
        public new string Url {
            get {
                return base.Url;
            }
            set {
                if ((((this.IsLocalFileSystemWebService(base.Url) == true) 
                            && (this.useDefaultCredentialsSetExplicitly == false)) 
                            && (this.IsLocalFileSystemWebService(value) == false))) {
                    base.UseDefaultCredentials = false;
                }
                base.Url = value;
            }
        }
        
        public new bool UseDefaultCredentials {
            get {
                return base.UseDefaultCredentials;
            }
            set {
                base.UseDefaultCredentials = value;
                this.useDefaultCredentialsSetExplicitly = true;
            }
        }
        
        /// <remarks/>
        public event BuscarHabilidadesCompletedEventHandler BuscarHabilidadesCompleted;
        
        /// <remarks/>
        public event AgrearHabilidadCompletedEventHandler AgrearHabilidadCompleted;
        
        /// <remarks/>
        [System.Web.Services.Protocols.SoapDocumentMethodAttribute("", RequestNamespace="http://servicios/", ResponseNamespace="http://servicios/", Use=System.Web.Services.Description.SoapBindingUse.Literal, ParameterStyle=System.Web.Services.Protocols.SoapParameterStyle.Wrapped)]
        [return: System.Xml.Serialization.XmlElementAttribute("return", Form=System.Xml.Schema.XmlSchemaForm.Unqualified)]
        public habilidad[] BuscarHabilidades([System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified)] int idUser) {
            object[] results = this.Invoke("BuscarHabilidades", new object[] {
                        idUser});
            return ((habilidad[])(results[0]));
        }
        
        /// <remarks/>
        public void BuscarHabilidadesAsync(int idUser) {
            this.BuscarHabilidadesAsync(idUser, null);
        }
        
        /// <remarks/>
        public void BuscarHabilidadesAsync(int idUser, object userState) {
            if ((this.BuscarHabilidadesOperationCompleted == null)) {
                this.BuscarHabilidadesOperationCompleted = new System.Threading.SendOrPostCallback(this.OnBuscarHabilidadesOperationCompleted);
            }
            this.InvokeAsync("BuscarHabilidades", new object[] {
                        idUser}, this.BuscarHabilidadesOperationCompleted, userState);
        }
        
        private void OnBuscarHabilidadesOperationCompleted(object arg) {
            if ((this.BuscarHabilidadesCompleted != null)) {
                System.Web.Services.Protocols.InvokeCompletedEventArgs invokeArgs = ((System.Web.Services.Protocols.InvokeCompletedEventArgs)(arg));
                this.BuscarHabilidadesCompleted(this, new BuscarHabilidadesCompletedEventArgs(invokeArgs.Results, invokeArgs.Error, invokeArgs.Cancelled, invokeArgs.UserState));
            }
        }
        
        /// <remarks/>
        [System.Web.Services.Protocols.SoapDocumentMethodAttribute("", RequestNamespace="http://servicios/", ResponseNamespace="http://servicios/", Use=System.Web.Services.Description.SoapBindingUse.Literal, ParameterStyle=System.Web.Services.Protocols.SoapParameterStyle.Wrapped)]
        [return: System.Xml.Serialization.XmlElementAttribute("return", Form=System.Xml.Schema.XmlSchemaForm.Unqualified)]
        public bool AgrearHabilidad([System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified)] string habilidad, [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified)] int karma, [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified)] int idUser) {
            object[] results = this.Invoke("AgrearHabilidad", new object[] {
                        habilidad,
                        karma,
                        idUser});
            return ((bool)(results[0]));
        }
        
        /// <remarks/>
        public void AgrearHabilidadAsync(string habilidad, int karma, int idUser) {
            this.AgrearHabilidadAsync(habilidad, karma, idUser, null);
        }
        
        /// <remarks/>
        public void AgrearHabilidadAsync(string habilidad, int karma, int idUser, object userState) {
            if ((this.AgrearHabilidadOperationCompleted == null)) {
                this.AgrearHabilidadOperationCompleted = new System.Threading.SendOrPostCallback(this.OnAgrearHabilidadOperationCompleted);
            }
            this.InvokeAsync("AgrearHabilidad", new object[] {
                        habilidad,
                        karma,
                        idUser}, this.AgrearHabilidadOperationCompleted, userState);
        }
        
        private void OnAgrearHabilidadOperationCompleted(object arg) {
            if ((this.AgrearHabilidadCompleted != null)) {
                System.Web.Services.Protocols.InvokeCompletedEventArgs invokeArgs = ((System.Web.Services.Protocols.InvokeCompletedEventArgs)(arg));
                this.AgrearHabilidadCompleted(this, new AgrearHabilidadCompletedEventArgs(invokeArgs.Results, invokeArgs.Error, invokeArgs.Cancelled, invokeArgs.UserState));
            }
        }
        
        /// <remarks/>
        public new void CancelAsync(object userState) {
            base.CancelAsync(userState);
        }
        
        private bool IsLocalFileSystemWebService(string url) {
            if (((url == null) 
                        || (url == string.Empty))) {
                return false;
            }
            System.Uri wsUri = new System.Uri(url);
            if (((wsUri.Port >= 1024) 
                        && (string.Compare(wsUri.Host, "localHost", System.StringComparison.OrdinalIgnoreCase) == 0))) {
                return true;
            }
            return false;
        }
    }
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Xml", "4.7.2556.0")]
    [System.SerializableAttribute()]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.ComponentModel.DesignerCategoryAttribute("code")]
    [System.Xml.Serialization.XmlTypeAttribute(Namespace="http://servicios/")]
    public partial class habilidad {
        
        private int idField;
        
        private string habilidad1Field;
        
        private int karmaField;
        
        /// <remarks/>
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified)]
        public int id {
            get {
                return this.idField;
            }
            set {
                this.idField = value;
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.XmlElementAttribute("habilidad", Form=System.Xml.Schema.XmlSchemaForm.Unqualified)]
        public string habilidad1 {
            get {
                return this.habilidad1Field;
            }
            set {
                this.habilidad1Field = value;
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified)]
        public int karma {
            get {
                return this.karmaField;
            }
            set {
                this.karmaField = value;
            }
        }
    }
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Web.Services", "4.7.2556.0")]
    public delegate void BuscarHabilidadesCompletedEventHandler(object sender, BuscarHabilidadesCompletedEventArgs e);
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Web.Services", "4.7.2556.0")]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.ComponentModel.DesignerCategoryAttribute("code")]
    public partial class BuscarHabilidadesCompletedEventArgs : System.ComponentModel.AsyncCompletedEventArgs {
        
        private object[] results;
        
        internal BuscarHabilidadesCompletedEventArgs(object[] results, System.Exception exception, bool cancelled, object userState) : 
                base(exception, cancelled, userState) {
            this.results = results;
        }
        
        /// <remarks/>
        public habilidad[] Result {
            get {
                this.RaiseExceptionIfNecessary();
                return ((habilidad[])(this.results[0]));
            }
        }
    }
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Web.Services", "4.7.2556.0")]
    public delegate void AgrearHabilidadCompletedEventHandler(object sender, AgrearHabilidadCompletedEventArgs e);
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Web.Services", "4.7.2556.0")]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.ComponentModel.DesignerCategoryAttribute("code")]
    public partial class AgrearHabilidadCompletedEventArgs : System.ComponentModel.AsyncCompletedEventArgs {
        
        private object[] results;
        
        internal AgrearHabilidadCompletedEventArgs(object[] results, System.Exception exception, bool cancelled, object userState) : 
                base(exception, cancelled, userState) {
            this.results = results;
        }
        
        /// <remarks/>
        public bool Result {
            get {
                this.RaiseExceptionIfNecessary();
                return ((bool)(this.results[0]));
            }
        }
    }
}

#pragma warning restore 1591