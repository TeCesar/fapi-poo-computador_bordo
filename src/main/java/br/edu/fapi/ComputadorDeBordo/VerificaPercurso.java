package br.edu.fapi.ComputadorDeBordo;
//diminuiDurabilidadePneu**
public class VerificaPercurso {
    
    public float verificarGasolina (){
        ComputadorDeBordo computadorDeBordo = new ComputadorDeBordo();
        
        return computadorDeBordo.getCarro().getTanqueDeGasolina().getLitrosAtual();
        
    }
    
    public void diminuiDurabilidadePneu (ComputadorDeBordo computadorDeBordo, int KM){
        int quilometragem;
        
    if(KM == 0){
        quilometragem = computadorDeBordo.getCarro().getPneuDianteiroEsquerdo().getDurabilidadePneu() - computadorDeBordo.getCarro().getPneuDianteiroEsquerdo().getQuilometragemPneu();
    }else{
        quilometragem = computadorDeBordo.getCarro().getPneuDianteiroEsquerdo().getDurabilidadePneu();
    }
               int quilometragemDiminuida = quilometragem - 1;
               
               computadorDeBordo.getCarro().getPneuDianteiroEsquerdo().setDurabilidadePneu(quilometragemDiminuida);
               computadorDeBordo.getCarro().getPneuDianteiroDireito().setDurabilidadePneu(quilometragemDiminuida);
               computadorDeBordo.getCarro().getPneuTraseiroEsquerdo().setDurabilidadePneu(quilometragemDiminuida);
               computadorDeBordo.getCarro().getPneuTraseiroDireito().setDurabilidadePneu(quilometragemDiminuida);
    }
    
    public int verificarPneus (){
        ComputadorDeBordo computadorDeBordo = new ComputadorDeBordo();
        
        return computadorDeBordo.getCarro().getPneuDianteiroDireito().getQuilometragemPneu();
                
    }
    
    public boolean verificarTetoSolar (ComputadorDeBordo computadorDeBordo){
        return computadorDeBordo.getCarro().getTetoSolar().isPossuiTetoSolar();
    }
    
    public boolean verificarBluetooth (ComputadorDeBordo computadorDeBordo){
        return computadorDeBordo.getCarro().getBluetooth().isPossuiBluetooth();
    }
    
    public boolean verificarStep (ComputadorDeBordo computadorDeBordo){
        if (computadorDeBordo.getCarro().getPneuStep().isStep() == true){
            System.out.println("Seu pneu furou. Substituindo pelo step.");
            System.out.println("");
        }else{
            System.out.println("Que pena. seu pneu furou e voc� n�o tem step.");
            System.out.println("");
            
        }
        return computadorDeBordo.getCarro().getPneuStep().isStep();
    }
    
    public void diminuiDurabilidadePneu_Step (ComputadorDeBordo computadorDeBordo){
            computadorDeBordo.getCarro().getPneuStep().setDurabilidadePneu(computadorDeBordo.getCarro().getPneuStep().getDurabilidadePneu() - 1);
        }
    
    
    public void diminuirGasolina (ComputadorDeBordo computadorDeBordo){
        computadorDeBordo.getCarro().getTanqueDeGasolina().setContadorAutonomia(computadorDeBordo.getCarro().getTanqueDeGasolina().getContadorAutonomia() + 1);
        if (computadorDeBordo.getCarro().getTanqueDeGasolina().getContadorAutonomia() == computadorDeBordo.getCarro().getTanqueDeGasolina().getAutonomiaTanque()){
            computadorDeBordo.getCarro().getTanqueDeGasolina().setLitrosAtual(computadorDeBordo.getCarro().getTanqueDeGasolina().getLitrosAtual() - 1);
            computadorDeBordo.getCarro().getTanqueDeGasolina().setContadorAutonomia(0);
        }
    }
    
}
