package atividadePontuada2;

import javax.sound.midi.Soundbank;
import java.util.List;
import java.util.Scanner;

public class MenuImoveis {
//    Listar imoveis cadastrados
    static Lista<Imovel> imoveis = new Lista<>();

//    Listar Regioes cadastradas
    static Lista<Regiao> regioes = new Lista<>();

//    Listar contribuintes cadastrados
    static Lista<Contribuinte> contribuintes = new Lista<>();

    public static void main(String[] args){
        System.out.println("Bem vindo!");
        String resposta = mostrarMenu();
        while (!resposta.equals("7")){
            if(resposta.equals("1")){
                cadastrarRegiao();
                resposta = mostrarMenu();
            } else if (resposta.equals("2")) {
                cadastrarImovel();
                resposta = mostrarMenu();
            } else if (resposta.equals("3")) {
                cadastrarContribuinte();
                resposta = mostrarMenu();
            } else if (resposta.equals("4")) {
                transferirImovel();
                resposta = mostrarMenu();
            }else if(resposta.equals("5")){
                atualizarValorRegiao();
                resposta = mostrarMenu();
            }else if (resposta.equals("6")){
                listarImoveisContribuinte();
                resposta = mostrarMenu();
            }
        }
    }

//    Buscar regiao por nome ou codigo
    public static Regiao buscarRegiao(String busca){
        Regiao regiaoDesejada = new Regiao();
        regioes.forEach(regiao -> {
            if(regiao.getCodigo().equals(busca) || regiao.getNome().equals(busca)){
                regiaoDesejada.setCodigo(regiao.getCodigo());
                regiaoDesejada.setNome(regiao.getNome());
                regiaoDesejada.setDescricao(regiao.getDescricao());
                regiaoDesejada.setValorMetroQuadrado(regiao.getValorMetroQuadrado());
            }else{
                return;
            }
        });
        return regiaoDesejada;
    }

//    Buscar imovel por codigo do imovel
    public static Imovel buscarImovelPorCodigo(Integer numeroImovel){
        Imovel imovelDesejado = new Imovel();
        imoveis.forEach(imovel -> {
            if(imovel.getNumeroInscricaoImob().equals(numeroImovel)){
                imovelDesejado.setEndereço(imovel.getEndereço());
                imovelDesejado.setProprietario(imovel.getProprietario());
                imovelDesejado.setNome(imovel.getNome());
                imovelDesejado.setRegiaoImovel(imovel.getRegiaoImovel());
                imovelDesejado.setArea(imovel.getArea());
                imovelDesejado.setNumeroInscricaoImob(imovel.getNumeroInscricaoImob());
            }
        });
        return imovelDesejado;
    }

//    Buscar contribuinte por CPF
    public static Contribuinte buscarContribuinte(String busca){
        Contribuinte contribuinteDesejado =  new Contribuinte();
        contribuintes.forEach(contribuinte -> {
            if (contribuinte.getCodigoPessoal().equals(busca)){
                contribuinteDesejado.setNome(contribuinte.getNome());
                contribuinteDesejado.setCodigoPessoal(contribuinte.getCodigoPessoal());
            }
        });
        return contribuinteDesejado;
    }

//    Buscar imoveis do contribuinte
    public static Lista<Imovel> imoveisPorContribuinte(Contribuinte contribuinte){
        Lista<Imovel> imoveisContribuinte = new Lista<>();
        imoveis.forEach(imovel -> {
            if(imovel.getProprietario().equals(contribuinte)){
                imoveisContribuinte.adicionar(imovel);
            }
        });
        return imoveisContribuinte;
    }

//    Mostrar menu de utilizacao
    public static String mostrarMenu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o numero da acao desejada");
        System.out.println("1 - Cadastrar Regiao");
        System.out.println("2 - Cadastrar Imovel");
        System.out.println("3 - Cadastrar Contribuinte");
        System.out.println("4 - Transferir Imovel e calcular ITBI");
        System.out.println("5 - Atualizar valor do M² na regiao");
        System.out.println("6 - Listar imoveis do contribuinte");
        System.out.println("7 - Sair");
        return scanner.nextLine();
    }

//    Metodo para cadastrar regiao
    public static void cadastrarRegiao(){
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite o codigo da regiao: ");
        String codigo = entrada.nextLine();
        System.out.println("Digite o nome da regiao: ");
        String nome = entrada.nextLine();
        System.out.println("Digite a descricao da regiao: ");
        String descricao = entrada.nextLine();
        System.out.println("Digite o valor do M² na regiao: ");
        Double metroQuadrado = entrada.nextDouble();
        entrada.close();
        Regiao regiao = new Regiao(codigo, nome, descricao, metroQuadrado);
        regioes.adicionar(regiao);
    }

    public static void cadastrarImovel(){
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite o numero da inscricao imobiliaria");
        Integer numInsImob = entrada.nextInt();
        entrada.nextLine();
        System.out.println("Digite o nome do imovel");
        String nome = entrada.next();
        System.out.println("Digite o endereco do imovel");
        String endereco = entrada.nextLine();
        System.out.println("Regioes disponiveis para cadastrar o imovel: ");;
        regioes.forEach(regiao -> {
            System.out.println(regiao.toString());
        });
        System.out.println("Digite a regiao qual deseja cadastrar o imovel");
        String nomeRegiao =  entrada.nextLine();
        System.out.println("Digite a area do imovel");
        Double area = entrada.nextDouble();
        entrada.nextLine();
        System.out.println("Digite o CPF/CNPJ proprietario do imovel");
        String codigoProp = entrada.nextLine();
        Imovel imovel = new Imovel();
        imovel.setArea(area);
        imovel.setRegiaoImovel(buscarRegiao(nomeRegiao));
        imovel.setNome(nome);
        imovel.setProprietario(buscarContribuinte(codigoProp));
        imovel.setEndereço(endereco);
        imovel.setNumeroInscricaoImob(numInsImob);
        imoveis.adicionar(imovel);
    }

    public static void cadastrarContribuinte(){
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite o CPF/CNPJ do contribuinte");
        String codigoPessoal = entrada.nextLine();
        System.out.println("Digite o nome do contribuinte");
        String nome = entrada.nextLine();
        Contribuinte contribuinte =  new Contribuinte(codigoPessoal, nome);
        contribuintes.adicionar(contribuinte);
    }

    public static void transferirImovel(){
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite o CPF/CNPJ do vendedor");
        String codigoVendedor = entrada.nextLine();
        System.out.println("Digite o CPF/CNPJ do comprador");
        String codigoComprador = entrada.nextLine();
        System.out.println("Digite o numero de inscrição do imovel");
        Integer numeroInscricao = entrada.nextInt();
        entrada.nextLine();
        System.out.println("Digite o valor de compra do imovel");
        Double valorCompra = entrada.nextDouble();
        Contribuinte vendedor = buscarContribuinte(codigoVendedor);
        Contribuinte comprador = buscarContribuinte(codigoComprador);
        Lista<Imovel> imoveisVendedor = imoveisPorContribuinte(vendedor);
        Imovel imovelVendido = buscarImovelPorCodigo(numeroInscricao);
        if(imoveisVendedor.contem(imovelVendido) == false){
            System.out.println("Vendedor nao possui esse imovel");
            return;
        }
        imovelVendido.setProprietario(comprador);
        System.out.println("ITBI: " + valorCompra * 0.2);
    }

    public static void atualizarValorRegiao(){
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite o codigo/nome da regiao: ");
        String busca = entrada.nextLine();
        Regiao regiao = buscarRegiao(busca);
        System.out.println("Digite o novo valor da regiao: ");
        Double valor = entrada.nextDouble();
        entrada.nextLine();
        regiao.setValorMetroQuadrado(valor);
    }

    public static void listarImoveisContribuinte(){
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite o CPF/CNPJ do contribuinte");
        String codigo = entrada.nextLine();
        Contribuinte contribuinte = buscarContribuinte(codigo);
        Lista<Imovel> imoveis = imoveisPorContribuinte(contribuinte);
        System.out.println(contribuinte.toString());
        imoveis.forEach(imovel -> {
            System.out.println(imovel.toString());
        });
    }
}
