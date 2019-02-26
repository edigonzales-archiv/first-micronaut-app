package products;

import javax.inject.Singleton;

import org.interlis2.validator.Validator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.ehi.basics.logging.EhiLogger;
import ch.ehi.basics.settings.Settings;

@Singleton
public class ValidationService {
    private static final Logger log = LoggerFactory.getLogger(ValidationService.class);

    public void validate(String inputFileName) {
        log.info("Validating...");
        log.info(inputFileName);
        
        
        EhiLogger.getInstance().setTraceFilter(false);
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_ILIDIRS, Validator.SETTING_DEFAULT_ILIDIRS);
        settings.setValue(Validator.SETTING_LOGFILE, "/Users/stefan/tmp/fubar_validator.log");
        
        boolean valid = Validator.runValidation(inputFileName, settings);
    }
}
