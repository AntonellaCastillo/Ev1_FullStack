package com.castillo.antonella.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.castillo.antonella.model.Evento;
import com.castillo.antonella.repository.EventoRepository;


@Service
public class EventoService 
{
    @Autowired
    private EventoRepository eventoRepository;

    public List<Evento> readAll()
    {
        return eventoRepository.obtenerEventos();

    }

    public Evento create(Evento evento)
    {
        return eventoRepository.guardarEvento(evento);

    }

    public Evento readById(int id)
    {
        return eventoRepository.buscarPorId(id);
    }

    public Evento update(int id, Evento evento)
    {
        return eventoRepository.actualizarEvento(id, evento);

    }

    public boolean delete(int id)
    {
        return eventoRepository.eliminarEvento(id);
    }

    public List<Evento> readByTipo(String tipoEvento)
    {
        return eventoRepository.flitrarEventosPorTipo(tipoEvento);

    }

    public List<Evento> orderByFecha()
    {
        return eventoRepository.ordenarPorFecha();
    }

}
