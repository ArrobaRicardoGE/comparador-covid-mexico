import PySimpleGUI as sg
import util,os

progress_bar = sg.ProgressBar(100,size=(25,10),visible=False)

messages = sg.Text(visible=False,size=(25,1),justification='center')

layout = [
    [sg.Text('Día anterior')],[sg.Input(key='-FILE1-',disabled=True,default_text=util.gui_constants.FILE_PLACEHOLDER ),sg.FileBrowse()],
    [sg.Text('Día reciente')],[sg.Input(key='-FILE2-',disabled=True,default_text=util.gui_constants.FILE_PLACEHOLDER ),sg.FileBrowse()],
    [sg.Button('Comparar')],
    [progress_bar],
    [messages]
    ]

window = sg.Window('Comparador Covid',layout,element_justification='c')

while True:
    event, values = window.read()
    if event == 'Comparar':
        if values['-FILE1-'] == util.gui_constants.FILE_PLACEHOLDER or values['-FILE2-'] == util.gui_constants.FILE_PLACEHOLDER:
            messages.update(value=util.gui_constants.FILE_NOT_SELECTED,text_color='#FF0000',visible=True)
        else:
            messages.update(value=util.gui_constants.READING_FILE.format(os.path.basename(values['-FILE1-'])),text_color='#0000FF',visible=True)
            progress_bar.update(0,visible=True)
            messages.update(value=util.gui_constants.READING_FILE.format(os.path.basename(values['-FILE2-'])),text_color='#0000FF',visible=True)
            progress_bar.update(25,visible=True)
            messages.update(value=util.gui_constants.GENERATING,text_color='#0000FF',visible=True)
            progress_bar.update(50,visible=True)

    if event == sg.WIN_CLOSED:
        break

window.close()