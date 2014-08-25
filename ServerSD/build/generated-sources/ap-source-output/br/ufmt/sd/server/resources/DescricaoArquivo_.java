package br.ufmt.sd.server.resources;

import br.ufmt.sd.server.resources.Cliented;
import br.ufmt.sd.server.resources.ItemBuscaNome;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-08-24T19:49:27")
@StaticMetamodel(DescricaoArquivo.class)
public class DescricaoArquivo_ { 

    public static volatile ListAttribute<DescricaoArquivo, Cliented> clientedList;
    public static volatile ListAttribute<DescricaoArquivo, ItemBuscaNome> itemBuscaNomeList;
    public static volatile SingularAttribute<DescricaoArquivo, Long> tamanho;
    public static volatile SingularAttribute<DescricaoArquivo, String> md5arquivo;

}