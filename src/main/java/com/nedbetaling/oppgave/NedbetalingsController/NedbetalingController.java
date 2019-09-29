package com.nedbetaling.oppgave.NedbetalingsController;

import com.nedbetaling.oppgave.BetalingsplanDto.ForesporselDto;
import com.nedbetaling.oppgave.BetalingsplanDto.NedbetalingsDto;
import com.nedbetaling.oppgave.Domain.Nedbetaling;
import com.nedbetaling.oppgave.Service.NedbetalingsService;
import org.json.JSONObject;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Kontrollerklasse
 */
@Controller
class NedbetalingController {

    @Autowired
    private ModelMapper modelMapper;

    /**
     * Behandler requests og returnerer nedbetalingsplan.
     * @param foresporselDto innhold i GET-request
     * @return responsliste med nedbetalinger (Såg ikkje på transportobjekt her som naudsynt.)
     */
    @RequestMapping(value = "/nedbetalingsplan", method = RequestMethod.GET)
    @ResponseBody
    public List<NedbetalingsDto> getNedbetalingsplan(@RequestBody ForesporselDto foresporselDto) {
        NedbetalingsService nedbetalingsService = new NedbetalingsService(foresporselDto);
        List<Nedbetaling> nedbetalingsplan = nedbetalingsService.nedbetaling();

        return nedbetalingsplan.stream()
                .map(nedbetaling -> convertToDto(nedbetaling))
                .collect(Collectors.toList());
    }

    /**
     * Konverter til nedbetalingsdto
     *
     * @param nedbetaling domeneobjekt som holder informasjon om nebetaling
     * @return et NedbetalingsDto som holder minimal versjon av Nedbetaling
     */
    private NedbetalingsDto convertToDto(Nedbetaling nedbetaling) {
        NedbetalingsDto nedbetalingsDto = modelMapper.map(nedbetaling, NedbetalingsDto.class);
        return nedbetalingsDto;
    }
}