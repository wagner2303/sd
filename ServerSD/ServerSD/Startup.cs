using Microsoft.Owin;
using Owin;

[assembly: OwinStartupAttribute(typeof(ServerSD.Startup))]
namespace ServerSD
{
    public partial class Startup
    {
        public void Configuration(IAppBuilder app)
        {
            ConfigureAuth(app);
        }
    }
}
