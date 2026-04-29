package com.veylik.notes.presentation.screens.creation

import androidx.lifecycle.ViewModel
import com.veylik.notes.data.TestNotesRepositoryImpl
import com.veylik.notes.domain.AddNoteUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class CreateNoteViewModel : ViewModel() {

    private val repository = TestNotesRepositoryImpl
    private val addNoteUseCommand = AddNoteUseCase(repository)

    private val _state = MutableStateFlow<CreateNoteState>(
        CreateNoteState.Creation()
    )
    val state = _state.asStateFlow()

    fun processCommand(command: CreateNoteCommand) {
        when(command) {
            CreateNoteCommand.Back -> {
                _state.update { CreateNoteState.Finished }
            }
            is CreateNoteCommand.InputContent -> {

            }
            is CreateNoteCommand.InputTitle -> {

            }
            CreateNoteCommand.Save -> {

            }
        }
    }
}


sealed interface CreateNoteCommand {

    data class InputTitle(val title: String) : CreateNoteCommand
    data class InputContent(val content: String) : CreateNoteCommand

    data object Save : CreateNoteCommand
    data object Back : CreateNoteCommand
}

sealed interface CreateNoteState {

    data class Creation(
        val title: String = "",
        val content: String = "",
        val isSaveEnabled: Boolean = false
    ) : CreateNoteState

    data object Finished : CreateNoteState
}