package edu.eci.cvds.managedbeans;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Horario;
import edu.eci.cvds.entities.Recurso;
import edu.eci.cvds.entities.Reserva;
import edu.eci.cvds.services.AdministratorServicesLibrary;
import edu.eci.cvds.services.LibraryServicesException;
import edu.eci.cvds.services.ServicesLibrary;
import java.io.IOException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.ScheduleEntryMoveEvent;
import org.primefaces.event.ScheduleEntryResizeEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.PieChartModel;

@SuppressWarnings("deprecation")
@ManagedBean(name = "recursoBean")
@SessionScoped
public class RecursoBean extends BasePageBean {

    private static final transient Logger log = LoggerFactory.getLogger(UserBean.class);
    private ScheduleModel eventModel = new DefaultScheduleModel();
    private ScheduleEvent event = new DefaultScheduleEvent();

    private String[] ubicaciones = {"Bibioteca B", "Bibioteca G"};
    private String ubicacionSeleccionada;

    private String[] tipos = {"Computador", "Multimedia", "Sala de estudio"};
    private String tipoSleccionado;

    private String[] estadosRecurso = {"Disponible", "No Disponible"};
    private String estadoSeleccionado;
    private int idSeleccionado;
    private String usuario;
    private int idRecurso;

    private Date horaInicial;
    private Date horaFinal;

    @Inject
    private ServicesLibrary servicesL;

    @Inject
    private AdministratorServicesLibrary servicesA;

    private Recurso recurso;

    private PieChartModel ubicacionRecursosGra;
    private BarChartModel tipoDeReservasGra;
    private BarChartModel recursoMasUsadosGra;
    private BarChartModel recursoMenosUsadosGra;
    private BarChartModel horariosMasUsadosGra;
    private BarChartModel horariosMenosUsadosGra;

    private BarChartModel initBarModel() {
        BarChartModel model = new BarChartModel();

        int cantNormales = 0;
        int cantRecurrentes = 0;
        int cantCanceladas = 0;

        try {
            for (Reserva r : servicesL.consultarReservas()) {
                if (r.getEstado().equals("Cancelada")) {
                    cantCanceladas += 1;
                } else if (r.getTipo().equals("Normal")) {
                    cantNormales += 1;
                } else if (r.getTipo().equals("Recurrente")) {
                    cantRecurrentes += 1;
                }
            }
        } catch (LibraryServicesException ex) {
            java.util.logging.Logger.getLogger(RecursoBean.class.getName()).log(Level.SEVERE, null, ex);
        }

        ChartSeries diarias = new ChartSeries();
        diarias.setLabel("Reservas normales");
        diarias.set("Reservas", cantNormales);

        ChartSeries recurrentes = new ChartSeries();
        recurrentes.setLabel("Reservas recurrentes");
        recurrentes.set("Reservas", cantRecurrentes);

        ChartSeries canceladas = new ChartSeries();
        canceladas.setLabel("Reservas canceladas");
        canceladas.set("Reservas", cantCanceladas);

        model.addSeries(diarias);
        model.addSeries(recurrentes);
        model.addSeries(canceladas);

        return model;
    }

    public BarChartModel getTipoDeReservasGra() {
        recursoMasUsadosGra = initBarModel();
        recursoMasUsadosGra.setTitle("Tipo de reservas");
        recursoMasUsadosGra.setAnimate(true);
        recursoMasUsadosGra.setLegendPosition("ne");
        Axis yAxis = recursoMasUsadosGra.getAxis(AxisType.Y);
        yAxis.setLabel("Cantidad de reservas");
        yAxis.setMin(0);
        yAxis.setMax(50);
        return recursoMasUsadosGra;
    }

    private BarChartModel initBarMasYMenosUsados(char tipo) {
        BarChartModel model = new BarChartModel();
        int cant = 5;
        int prueba = 10;
        if (tipo == '+') {
            for (int i = 0; i <= cant; i++) {
                //servicesA.reporteDeOcupacion();
                ChartSeries ChartS = new ChartSeries();
                //Nombre del recurso
                ChartS.setLabel("NombreRecurso");
                //Cantidad de reservas
                ChartS.set("Recursos",prueba);
                model.addSeries(ChartS);
                prueba += 6;
            }
        } else {
            for (int i = 0; i <= cant; i++) {
                //servicesA.reporteDeOcupacion();
                ChartSeries ChartS = new ChartSeries();
                //Nombre del recurso
                ChartS.setLabel("NombreRecurso");
                //Cantidad de reservas
                ChartS.set("Recursos",prueba);
                model.addSeries(ChartS);
                prueba -= 1;
            }
        }

        return model;
    }

    public BarChartModel getRecursoMasUsadosGra() {
        tipoDeReservasGra = initBarMasYMenosUsados('+');
        tipoDeReservasGra.setTitle("Recursos mas usados");
        tipoDeReservasGra.setAnimate(true);
        tipoDeReservasGra.setLegendPosition("ne");
        Axis yAxis = tipoDeReservasGra.getAxis(AxisType.Y);
        yAxis.setLabel("Cantidad de reservas");
        yAxis.setMin(0);
        yAxis.setMax(50);
        return tipoDeReservasGra;
    }

    public BarChartModel getRecursoMenosUsadosGra() {
        recursoMenosUsadosGra = initBarMasYMenosUsados('-');
        recursoMenosUsadosGra.setTitle("Recursos menos usados");
        recursoMenosUsadosGra.setAnimate(true);
        recursoMenosUsadosGra.setLegendPosition("ne");
        Axis yAxis = recursoMenosUsadosGra.getAxis(AxisType.Y);
        yAxis.setLabel("Cantidad de reservas");
        yAxis.setMin(0);
        yAxis.setMax(50);
        return recursoMenosUsadosGra;
    }
    
    private BarChartModel initBarHorariosMasYMenosUsados(char tipo) {
        BarChartModel model = new BarChartModel();
        int cant = 5;
        int prueba = 10;
        if (tipo == '+') {
            for (int i = 0; i <= cant; i++) {
                //servicesA.reporteDeOcupacion();
                ChartSeries ChartS = new ChartSeries();
                //Hora de uso mas usada.
                ChartS.setLabel("Hora de Uso");
                //Cantidad de reservas.
                ChartS.set("Horas de reserva",prueba);
                model.addSeries(ChartS);
                prueba += 6;
            }
        } else {
            for (int i = 0; i <= cant; i++) {
                //servicesA.reporteDeOcupacion();
                ChartSeries ChartS = new ChartSeries();
                //Nombre del recurso
                ChartS.setLabel("Hora de Uso");
                //Cantidad de reservas
                ChartS.set("Horas de reserva",prueba);
                model.addSeries(ChartS);
                prueba -= 1;
            }
        }

        return model;
    }

    public BarChartModel getHorariosMasUsadosGra() {
        horariosMasUsadosGra = initBarHorariosMasYMenosUsados('+');
        horariosMasUsadosGra.setTitle("Horarios de mayor ucupacion");
        horariosMasUsadosGra.setAnimate(true);
        horariosMasUsadosGra.setLegendPosition("ne");
        Axis yAxis = horariosMasUsadosGra.getAxis(AxisType.Y);
        yAxis.setLabel("Cantidad de reservas");
        yAxis.setMin(0);
        yAxis.setMax(50);
        return horariosMasUsadosGra;
    }

    public BarChartModel getHorariosMenosUsadosGra() {
        recursoMenosUsadosGra = initBarHorariosMasYMenosUsados('-');
        recursoMenosUsadosGra.setTitle("Horarios de menor ocupacion");
        recursoMenosUsadosGra.setAnimate(true);
        recursoMenosUsadosGra.setLegendPosition("ne");
        Axis yAxis = recursoMenosUsadosGra.getAxis(AxisType.Y);
        yAxis.setLabel("Cantidad de reservas");
        yAxis.setMin(0);
        yAxis.setMax(50);
        return recursoMenosUsadosGra;
    }

    public PieChartModel getUbicacionRecursosGra() {
        ubicacionRecursosGra = new PieChartModel();
        int cantBloqueB = 0;
        int cantBloqueG = 0;
        int conta = 0;
        try {
            for (Recurso r : servicesA.consultarRecursosAdmin()) {
                conta += 1;
                if (r.getUbicacion().equals("Biblioteca B")) {
                    cantBloqueB += 1;
                } else {
                    cantBloqueG += 1;
                }
            }
        } catch (LibraryServicesException ex) {
            java.util.logging.Logger.getLogger(RecursoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        ubicacionRecursosGra.set("Biblioteca bloque B", cantBloqueB);
        ubicacionRecursosGra.set("Biblioteca bloque G", cantBloqueG);
        ubicacionRecursosGra.setTitle("Ubicación de los recursos");
        ubicacionRecursosGra.setLegendPosition("e");
        ubicacionRecursosGra.setFill(false);
        ubicacionRecursosGra.setShowDataLabels(true);
        ubicacionRecursosGra.setDiameter(150);
        ubicacionRecursosGra.setShadow(false);

        return ubicacionRecursosGra;
    }

    public List<Recurso> getRecursosAdmin() throws LibraryServicesException {
        return servicesA.consultarRecursosAdmin();
    }

    public List<Recurso> getRecursos() throws LibraryServicesException {
        return servicesL.consultarRecursos();
    }

    public List<String> getEstados() {
        return recurso.getEstados();
    }

    public void editarEstadoRecurso() {
        if (estadoSeleccionado.equals("Disponible")) {
            try {
                servicesA.volverAAdmitirElRecurso(servicesL.consultarRecurso(idSeleccionado));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (estadoSeleccionado.equals("No Disponible")) {
            try {
                servicesA.eliminarUnRecursoTemporal(servicesL.consultarRecurso(idSeleccionado));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void seleccionarRecurso(int idSeleccionado) {
        this.idSeleccionado = idSeleccionado;
    }

    public void registrarRecurso(String nombre, int capacidad) throws LibraryServicesException {
        int id = servicesA.consultarRecursosAdmin().size() + 1;
        int tipo = buscarIndice();
        try {
            recurso = new Recurso(id, tipo + 1, nombre, ubicacionSeleccionada, capacidad, "Disponible", tipo + 1, tipos[tipo]);
            Horario h = new Horario();
            h.setHoraInicio(new Time(horaInicial.getHours(), horaInicial.getMinutes(), horaInicial.getSeconds()));
            h.setHoraFin(new Time(horaFinal.getHours(), horaFinal.getMinutes(), horaFinal.getSeconds()));
            servicesA.registrarRecurso(recurso);
            servicesA.ingresarHorario(recurso, h);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int buscarIndice() {
        int res = -1;
        for (int i = 0; i < tipos.length; i++) {
            if (tipoSleccionado.equals(tipos[i])) {
                res = i;
            }
        }
        return res;
    }

    public void eliminarRecurso(int id) {
        try {
            servicesA.eliminarUnRecursoPermanente(servicesL.consultarRecurso(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void reloadAdmin() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/admin/pages/cambiarEstadoRecurso.xhtml");
    }

    public void reloadUser() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/regular/pages/consultarRecursos.xhtml");
    }

    public void reloadGuest() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/consultarRecursos.xhtml");
    }

    public void reload(String tipo) throws IOException {
        if (tipo.equals("administrador")) {
            reloadAdmin();
        } else {
            reloadUser();
        }
    }

    public void verReservas() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/regular/pages/verReservas.xhtml");
    }

    //Calendario del recurso
    public void fillDate(int id) throws LibraryServicesException {
        eventModel = new DefaultScheduleModel();
        event = new DefaultScheduleEvent();
        Recurso re = servicesL.consultarRecurso(id);
        idRecurso = id;
        List<Reserva> lista = servicesL.consultarReservas();
        boolean banderaRec = false;
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getRecurso().getIdentificadorInterno() == id) {
                banderaRec = true;
            }
        }
        lista = servicesL.consultarReservaRecurso(re);
        if (banderaRec) {
            if (lista.size() > 0) {
                for (Reserva r : lista) {
                    event = new DefaultScheduleEvent(r.getRecurso().getNombre() + "  " + r.getUsuario().getNombre()+" "+r.getTipo(), r.getFechaIniDate(), r.getFechaFinDate());
                    ((DefaultScheduleEvent) event).setDescription(Integer.toString(r.getId()));
                    eventModel.addEvent(event);
                }
            }
        }
    }

    public Date getRandomDate(Date base) {
        Calendar date = Calendar.getInstance();
        date.setTime(base);
        date.add(Calendar.DATE, ((int) (Math.random() * 30)) + 1);    //set random day of month

        return date.getTime();
    }

    public Date getInitialDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR), Calendar.FEBRUARY, calendar.get(Calendar.DATE), 0, 0, 0);

        return calendar.getTime();
    }

    public ScheduleModel getEventModel() {
        return eventModel;
    }

    private Calendar today() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE), 0, 0, 0);

        return calendar;
    }

    public ScheduleEvent getEvent() {
        return event;
    }

    public void setEvent(ScheduleEvent event) {
        this.event = event;
    }

    public void addEvent(String tipoRecurencia, String cantidadRecurrencia) throws IOException {
        if (tipoRecurencia == null || tipoRecurencia.equals("")) {
            try {
                servicesL.reservarRecurso(servicesL.consultarRecurso(idSeleccionado), servicesL.consultarUsuario(usuario), new Timestamp(event.getStartDate().getTime()), new Timestamp(event.getEndDate().getTime()));
            } catch (LibraryServicesException e) {
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(null, new FacesMessage("Error", e.getMessage()));
            }
        } else {
            if (cantidadRecurrencia == null || cantidadRecurrencia.equals("")) {
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(null, new FacesMessage("Error", "No se selecciono la cantidad de la recurrencia en la reserva"));
            } else {
                try {
                    servicesL.reservaRecursorecurrente(servicesL.consultarRecurso(idSeleccionado), servicesL.consultarUsuario(usuario), new Timestamp(event.getStartDate().getTime()), new Timestamp(event.getEndDate().getTime()), tipoRecurencia, cantidadRecurrencia);
                    event = new DefaultScheduleEvent();
                    horariosPage(idSeleccionado);
                } catch (LibraryServicesException e) {
                    FacesContext context = FacesContext.getCurrentInstance();
                    context.addMessage(null, new FacesMessage("Error", e.getMessage()));
                }
            }
        }
    }

    public void onEventSelect(SelectEvent selectEvent) {
        event = (ScheduleEvent) selectEvent.getObject();
    }

    public void onDateSelect(SelectEvent selectEvent) {
        event = new DefaultScheduleEvent("", (Date) selectEvent.getObject(), (Date) selectEvent.getObject());
    }

    public void onEventMove(ScheduleEntryMoveEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event moved", "Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta());

        addMessage(message);
    }

    public void onEventResize(ScheduleEntryResizeEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event resized", "Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta());

        addMessage(message);
    }

    private void addMessage(FacesMessage message) {
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void deleteEvent(int idB) throws LibraryServicesException, IOException {
        eventModel.deleteEvent(event);
        servicesL.eliminarReserva(servicesL.consultarReserva(idB));
        FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/regular/pages/verReservas.xhtml");
    }

    public void horariosPage(int id) throws IOException, LibraryServicesException {
        idSeleccionado = id;
        fillDate(id);
        FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/general/pages/horarios.xhtml");
    }

    public void horariosPageGuest(int id) throws IOException, LibraryServicesException {
        idSeleccionado = id;
        fillDate(id);
        FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/horarios.xhtml");
    }

    public Reserva consultarReserva(String id) throws LibraryServicesException {
        System.out.println("id de la reserva "+id);
        return servicesL.consultarReserva(Integer.parseInt(id));
    }

    public String hacerFecha(Date date){
        String s = "";
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        s += c.get(Calendar.DAY_OF_MONTH)+"/";
        s += c.get(Calendar.MONTH)+"/";
        s += c.get(Calendar.YEAR)+" ";
        s += c.get(Calendar.HOUR_OF_DAY)+":";
        if (c.get(Calendar.MINUTE)<10){
            s += "0"+c.get(Calendar.MINUTE);
        }else {
            s += c.get(Calendar.MINUTE);
        }
        return s;
    }

    public void setUbicacionSeleccionada(String ubicacionSeleccionada) {
        this.ubicacionSeleccionada = ubicacionSeleccionada;
    }

    public String getUbicacionSeleccionada() {
        return this.ubicacionSeleccionada;
    }

    public String[] getUbicaciones() {
        return ubicaciones;
    }

    public String getTipoSleccionado() {
        return tipoSleccionado;
    }

    public void setTipoSleccionado(String tipoSleccionado) {
        this.tipoSleccionado = tipoSleccionado;
    }

    public String[] getTipos() {
        return tipos;
    }

    public String[] getEstadosRecurso() {
        return estadosRecurso;
    }

    public String getEstadoSeleccionado() {
        return estadoSeleccionado;
    }

    public void setEstadoSeleccionado(String estadoSeleccionado) {
        this.estadoSeleccionado = estadoSeleccionado;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public List<Reserva> getReservasUsuario() throws LibraryServicesException {
        return servicesL.consultarReservasUsuario(usuario);
    }

    public Date getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(Date horaFinal) {
        this.horaFinal = horaFinal;
    }

    public Date getHoraInicial() {
        return horaInicial;
    }

    public void setHoraInicial(Date horaInicial) {
        this.horaInicial = horaInicial;
    }
}
