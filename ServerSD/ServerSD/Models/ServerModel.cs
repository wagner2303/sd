namespace ServerSD.Models
{
    using System;
    using System.Data.Entity;
    using System.ComponentModel.DataAnnotations.Schema;
    using System.Linq;

    public partial class ServerModel : DbContext
    {
        public ServerModel()
            : base("name=ServerConnection")
        {
        }

        public virtual DbSet<ClienteD> ClienteD { get; set; }
        public virtual DbSet<DescricaoArquivo> DescricaoArquivo { get; set; }
        public virtual DbSet<ItemBuscaNome> ItemBuscaNome { get; set; }

        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.Entity<ClienteD>()
                .Property(e => e.endereco)
                .IsUnicode(false);

            modelBuilder.Entity<ClienteD>()
                .HasMany(e => e.DescricaoArquivo)
                .WithMany(e => e.ClienteD)
                .Map(m => m.ToTable("cliente_DescricaoArquivo").MapLeftKey("endereco").MapRightKey("md5Arquivo"));

            modelBuilder.Entity<DescricaoArquivo>()
                .Property(e => e.md5Arquivo)
                .IsFixedLength()
                .IsUnicode(false);

            modelBuilder.Entity<DescricaoArquivo>()
                .HasMany(e => e.ItemBuscaNome)
                .WithRequired(e => e.DescricaoArquivo)
                .WillCascadeOnDelete(false);

            modelBuilder.Entity<ItemBuscaNome>()
                .Property(e => e.idItemBuscaNome)
                .HasPrecision(18, 0);

            modelBuilder.Entity<ItemBuscaNome>()
                .Property(e => e.md5Arquivo)
                .IsFixedLength()
                .IsUnicode(false);

            modelBuilder.Entity<ItemBuscaNome>()
                .Property(e => e.nome)
                .IsUnicode(false);
        }
    }
}
