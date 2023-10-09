package org.df;

public class Empleado {

    private  String nombre;
    private  float horasSemana;
    private  float valorHora;
    private float salarioMensual;

    public Empleado(String nombre, float horasSemana, float valorHora) {
        this.nombre = nombre;
        this.horasSemana = horasSemana;
        this.valorHora = valorHora;
        calcularSalarioMensual();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getHorasSemana() {
        return horasSemana;
    }

    public void setHorasSemana(float horasSemana) {
        this.horasSemana = horasSemana;
    }

    public float getValorHora() {
        return valorHora;
    }

    public void setValorHora(float valorHora) {
        this.valorHora = valorHora;
    }

    public float getSalarioMensual() {
        return salarioMensual;
    }

    public void setSalarioMensual(float salarioMensual) {
        this.salarioMensual = salarioMensual;
    }

    public void calcularSalarioMensual() {
        float salarioSinDeducciones = valorHora * horasSemana * 4; // 4 semanas al mes
        float deduccionSalud = salarioSinDeducciones * 0.04f;
        float deduccionPension = salarioSinDeducciones * 0.04f;
        float deduccionCajaCompensacion = salarioSinDeducciones * 0.02f;
        float auxilioTransporte = 140606;
        salarioMensual = salarioSinDeducciones - deduccionSalud - deduccionPension - deduccionCajaCompensacion + auxilioTransporte;
    }
}
