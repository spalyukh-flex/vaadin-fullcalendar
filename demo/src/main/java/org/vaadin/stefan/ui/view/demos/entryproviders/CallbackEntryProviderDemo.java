package org.vaadin.stefan.ui.view.demos.entryproviders;

import com.vaadin.flow.router.Route;
import org.vaadin.stefan.fullcalendar.Entry;
import org.vaadin.stefan.fullcalendar.dataprovider.CallbackEntryProvider;
import org.vaadin.stefan.fullcalendar.dataprovider.EntryProvider;
import org.vaadin.stefan.ui.layouts.MainLayout;

import java.util.Collection;

/**
 * @author Stefan Uebe
 */
@Route(value = "callback-entry-provider", layout = MainLayout.class)
@org.vaadin.stefan.ui.menu.MenuItem(label = "Callback Entry Provider")
public class CallbackEntryProviderDemo extends AbstractEntryProviderDemo {

    public CallbackEntryProviderDemo() {
        super("TBD: callback entry provider");
    }

    @Override
    protected EntryProvider<Entry> createEntryProvider(EntryService service) {
        return new CallbackEntryProvider<>(service::streamEntries);
    }

    @Override
    protected void onSamplesCreated(Collection<Entry> entries) {
        getEntryService().addEntries(entries);
        getEntryProvider().refreshAll();
    }

    @Override
    protected void onSampleChanged(Entry entry) {
        getEntryService().updateEntry(entry);
        getEntryProvider().refreshAll();
    }

    @Override
    protected void onSamplesRemoved(Collection<Entry> entries) {
        getEntryService().removeAll();
        getEntryProvider().refreshAll();
    }


}
