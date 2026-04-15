package com.castillo.antonella.repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Repository;
import com.castillo.antonella.model.Evento;

@Repository

public class EventoRepository 
{
    private List<Evento> listaEventos = new ArrayList<>();

    public List<Evento> obtenerEventos()
    {
        return listaEventos;

    }

    public Evento guardarEvento(Evento evento)
    {
        listaEventos.add(evento);
        return evento;

    }

    public Evento buscarPorId(int id)
    {
        for (Evento evento : listaEventos)
        {
            if(evento.getId() == id)
                {
                    return evento;
                }
        } 
        return null;
    
    }
    

    public boolean actulizarEvento(int id, Evento eventoActulizado)
    {
        Evento evento = buscarPorId(id);

        if (evento != null)
        {
            listaEventos.remove(evento);
            return true;
        }
        return false;
    
    }

    public List<Evento> flitrarEventosPorTipo(String tipoEvento)
    {
        List<Evento> resultado = new ArrayList<>();

        for (Evento evento : listaEventos)
        {
            if (evento.getTipoEvento().equalsIgnoreCase(tipoEvento))
                {
                    resultado.add(evento);
                }
        
        
        }
        return resultado;
    
    }

    public List<Evento> ordenarPorFecha()
    {
        List<Evento> copia = new ArrayList<>(listaEventos);
        copia.sort(Comparator.comparing(Evento::getFechaRealizacion));

        return copia;
    }


}
